package com.BuildingWeb.Repository.Custom.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.BuildingWeb.Builder.BuildingSearchBuilder;
import com.BuildingWeb.DTO.RequestBuildingDTO;
import com.BuildingWeb.Entity.BuildingEntity;
import com.BuildingWeb.Entity.DistrictEntity;
import com.BuildingWeb.Repository.BuildingRepository;
import com.BuildingWeb.Repository.Custom.BuildingRepositoryCustom;
import com.BuildingWeb.Utils.StringUtil;
import java.lang.reflect.Field;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
    List<BuildingEntity> ListBuilding=new ArrayList<>();
    @Autowired
	ModelMapper modelmapper;
 
    @PersistenceContext
    private EntityManager entityManager;
	
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
				sql.append(" and rentarea.Area >= "+buildingsearchbuilder.getAreaFrom());
			}
			if(buildingsearchbuilder.getAreaTo()!=null) {
				sql.append(" and rentarea.Area <= "+buildingsearchbuilder.getAreaTo());
			}
		}
		if(buildingsearchbuilder.getTypeCode()!=null) {
			//sql.append(" and buildingtype.Code in( '"+String.join("','",BuildingType)+"')");
			sql.append(" and ( "+buildingsearchbuilder.getTypeCode().stream().map(str->"buildingtype.Code like '%"+str+"%'").collect(Collectors.joining(" or "))+")");
		}
		
	}
public List<BuildingEntity> FindAll(BuildingSearchBuilder buildingsearchbuilder){

	StringBuilder sql=new StringBuilder("select building.* from building ");
	JoinTable(buildingsearchbuilder,sql);
	    sql.append(" Where 1=1");
	NormalQuery(buildingsearchbuilder,sql);
	SpecialQuery(buildingsearchbuilder,sql);
	Query query=entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
	return query.getResultList();
}


}

