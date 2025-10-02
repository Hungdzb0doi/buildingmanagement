package com.BuildingWeb.Repository.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.BuildingWeb.Entity.BuildingEntity;


import com.BuildingWeb.Repository.BuildingRepository;
import com.BuildingWeb.Utils.ConnectionJDBCUtil;
import com.BuildingWeb.Utils.NumberUtil;
import com.BuildingWeb.Utils.StringUtil;

import java.sql.*;
@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    List<BuildingEntity> ListBuilding=new ArrayList<>();
	
	public void JoinTable(HashMap<String,Object> params,List<String> BuildingType, StringBuilder sql) {
		if(StringUtil.CheckString((String)params.get("district"))){
			sql.append(" join district on building.IdDistrict=district.IdDistrict");
		}
		if(StringUtil.CheckString((String)params.get("areafrom"))||StringUtil.CheckString((String)params.get("areato"))){
			sql.append(" join rentarea on building.IdBuilding=rentarea.IdBuilding");
		}
		if(StringUtil.CheckString((String)params.get("username"))){
			sql.append(" join buildinguser on building.IdBuilding=buildinguser.IdBuilding join user on user.IdUser=buildinguser.IdUser");
		}
		if(StringUtil.CheckString((String)params.get("buildingtype"))&&BuildingType.size()!=0) {
			sql.append(" join buildingtype on building.IdBuilding=buildingtype.IdBuilding");
		}
	
	}
	public void NormalQuery(HashMap<String,Object> params,List<String> BuildingType, StringBuilder sql) {
		for(Map.Entry<String,Object> It: params.entrySet()) {
			if(!It.getKey().equals("rent")&&!It.getKey().equals("buildingtype")&&!It.getKey().startsWith("area")&&It.getKey().startsWith("rent")) {
				if(NumberUtil.IsNumber((String)It.getValue())) {
					sql.append(" and "+It.getKey()+"="+It.getValue());
				}else {
					sql.append(" and "+It.getKey()+" like '%"+It.getValue()+"%' ");
				}
			}
		}
	}
	public void SpecialQuery(HashMap<String,Object> params,List<String> BuildingType, StringBuilder sql) {
		if(StringUtil.CheckString((String)params.get("rentfrom"))||StringUtil.CheckString((String)params.get("rentto"))){
			if(params.get("rentfrom")!=null) {
				sql.append(" and Rent >= "+params.get("rentfrom"));
			}
			if(params.get("rentto")!=null) {
				sql.append(" and Rent <= "+params.get("rentto"));
			}
		}
		if(StringUtil.CheckString((String)params.get("areafrom"))||StringUtil.CheckString((String)params.get("areato"))) {
			if(params.get("areafrom")!=null) {
				sql.append(" and Area >= "+params.get("areafrom"));
			}
			if(params.get("rentto")!=null) {
				sql.append(" and Area <= "+params.get("areato"));
			}
		}
		if(StringUtil.CheckString((String)params.get("buildingtype"))) {
			//sql.append(" and buildingtype.Code in( '"+String.join("','",BuildingType)+"')");
			sql.append(" and ( "+BuildingType.stream().map(str->"buildingtype.code like '%"+str+"%'").collect(Collectors.joining(" or "))+")");
		}
		if(StringUtil.CheckString((String)params.get("username"))) {
			sql.append(" and UserName like '%"+params.get("username")+"%'");
		}
	}
public List<BuildingEntity> FindAll(HashMap<String,Object> params,List<String> BuildingType){

	StringBuilder sql=new StringBuilder("select * from building ");
	JoinTable(params,BuildingType,sql);
	    sql.append(" Where 1=1");
	NormalQuery(params,BuildingType,sql);
	SpecialQuery(params,BuildingType,sql);
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
