package com.BuildingWeb.Repository.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.BuildingWeb.Builder.BuildingSearchBuilder;
import com.BuildingWeb.Entity.BuildingEntity;
import com.BuildingWeb.Repository.BuildingRepository;
import com.BuildingWeb.Utils.ConnectionJDBCUtil;
import com.BuildingWeb.Utils.StringUtil;
import java.lang.reflect.Field;
import java.sql.*;
@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    List<BuildingEntity> ListBuilding=new ArrayList<>();
	
	public void JoinTable(BuildingSearchBuilder buildingsearchbuilder, StringBuilder sql) {
		if(StringUtil.CheckString(buildingsearchbuilder.getDistrictName())){
			sql.append(" join district on building.IdDistrict=district.IdDistrict");
		}
		if(buildingsearchbuilder.getAreaFrom()!=null||buildingsearchbuilder.getAreaTo()!=null){
			sql.append(" join rentarea on building.IdBuilding=rentarea.IdBuilding");
		}
		if(StringUtil.CheckString(buildingsearchbuilder.getUserName())){
			sql.append(" join buildinguser on building.IdBuilding=buildinguser.IdBuilding join user on user.IdUser=buildinguser.IdUser");
		}
		if(buildingsearchbuilder.getTypeCode()!=null&&buildingsearchbuilder.getTypeCode().size()!=0) {
			sql.append(" join buildingtype on building.IdBuilding=buildingtype.IdBuilding");
		}
	
	}
	public void NormalQuery(BuildingSearchBuilder buildingsearchbuilder, StringBuilder sql) {
		try {
		Field[] fields=BuildingSearchBuilder.class.getDeclaredFields();
		for( Field It: fields) {
			It.setAccessible(true);
			if(It.get( buildingsearchbuilder)!=null) {
			if(!It.getName().equals("TypeCode")&&!It.getName().startsWith("Area")&&!It.getName().startsWith("Rent")) {
				if(It.getType().getName().equals("java.lang.Integer")) {
					sql.append(" and "+It.getName()+"="+It.get(buildingsearchbuilder));
				}else {
					sql.append(" and "+It.getName()+" like '%"+It.get(buildingsearchbuilder)+"%' ");
				}
			}
			}
		}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
	public void SpecialQuery(BuildingSearchBuilder buildingsearchbuilder, StringBuilder sql) {
		if(buildingsearchbuilder.getRentFrom()!=null||buildingsearchbuilder.getRentTo()!=null){
			if(buildingsearchbuilder.getRentFrom()!=null) {
				sql.append(" and Rent >= "+buildingsearchbuilder.getRentFrom());
			}
			if(buildingsearchbuilder.getRentTo()!=null) {
				sql.append(" and Rent <= "+buildingsearchbuilder.getRentTo());
			}
		}
		if(buildingsearchbuilder.getAreaFrom()!=null||buildingsearchbuilder.getAreaTo()!=null) {
			if(buildingsearchbuilder.getAreaFrom()!=null) {
				sql.append(" and Area >= "+buildingsearchbuilder.getAreaFrom());
			}
			if(buildingsearchbuilder.getAreaTo()!=null) {
				sql.append(" and Area <= "+buildingsearchbuilder.getAreaTo());
			}
		}
		if(buildingsearchbuilder.getTypeCode()!=null) {
			//sql.append(" and buildingtype.Code in( '"+String.join("','",BuildingType)+"')");
			sql.append(" and ( "+buildingsearchbuilder.getTypeCode().stream().map(str->"buildingtype.Code like '%"+str+"%'").collect(Collectors.joining(" or "))+")");
		}
		
	}
public List<BuildingEntity> FindAll(BuildingSearchBuilder buildingsearchbuilder){

	StringBuilder sql=new StringBuilder("select * from building ");
	JoinTable(buildingsearchbuilder,sql);
	    sql.append(" Where 1=1");
	NormalQuery(buildingsearchbuilder,sql);
	SpecialQuery(buildingsearchbuilder,sql);
	try(Connection con=ConnectionJDBCUtil.getConnection();
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery(sql.toString());	){
		while(rs.next()) {
			
			BuildingEntity bett=new BuildingEntity();
			
			bett.setIdBuilding(rs.getInt("IdBuilding"));
			bett.setBuildingName(rs.getString("BuildingName"));
			bett.setCode(rs.getString("Code"));
			bett.setWard(rs.getString("Ward"));
			bett.setWay(rs.getString("Way"));
			bett.setStructure(rs.getString("Structure"));
			bett.setNumberOfBasement(rs.getInt("NumberOfBasement"));
			bett.setFloorArea(rs.getInt("FloorArea"));
			bett.setDirection(rs.getString("Direction"));
			bett.setClass1(rs.getString("Class"));
			bett.setRent(rs.getInt("Rent"));
			bett.setDescriptionPrice(rs.getString("DescriptionPrice"));
			bett.setMotocycleFee(rs.getString("MotocycleFee"));
			bett.setCarFee(rs.getString("CarFee"));
			bett.setServiceFee(rs.getString("ServiceFee"));
			bett.setOverTimeFee(rs.getString("OverTimeFee"));
			bett.setElectricityBill(rs.getString("ElectricityBill"));
			bett.setDeposit(rs.getInt("Deposit"));
			bett.setPay(rs.getString("Pay"));
			bett.setLeaseTerm(rs.getString("Leaseterm"));
			bett.setDecorationTime(rs.getString("DecorationTime"));
			bett.setManagerName(rs.getString("ManagerName"));
			bett.setManagerPhone(rs.getString("ManagerPhone"));
			bett.setBrokerageFee(rs.getString("BrokerageFee"));
			bett.setNote(rs.getString("Note"));
			bett.setIdDistrict(rs.getInt("IdDistrict"));
			
			ListBuilding.add(bett);
			
		}
		
	}catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	return ListBuilding;
}}
