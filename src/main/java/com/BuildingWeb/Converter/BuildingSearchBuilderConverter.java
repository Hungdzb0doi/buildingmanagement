package com.BuildingWeb.Converter;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.BuildingWeb.Builder.BuildingSearchBuilder;
import com.BuildingWeb.Utils.MapUtil;
@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder ToBuildingSearchBuilder(HashMap<String,Object> params,List<String> BuildingType) {
		BuildingSearchBuilder buildingsearchbuilder=new BuildingSearchBuilder.Builder().setBuildingName(MapUtil.getObject(params, "buildingname", String.class))
																						.setDistrictName(MapUtil.getObject(params, "districtname", String.class))
																						.setManagerName(MapUtil.getObject(params, "managername", String.class))
																						.setManagerPhone(MapUtil.getObject(params, "managerphone", String.class))
																						.setUserName(MapUtil.getObject(params, "username", String.class))
																						.setWard(MapUtil.getObject(params, "ward", String.class))
																						.setWay(MapUtil.getObject(params, "way", String.class))
																						.setAreaFrom(MapUtil.getObject(params, "areafrom", Integer.class))
																						.setAreaTo(MapUtil.getObject(params, "areato", Integer.class))
																						.setNumberOfBasement(MapUtil.getObject(params, "numberofbasement", Integer.class))
																						.setRentFrom(MapUtil.getObject(params, "rentfrom", Integer.class))
																						.setRentTo(MapUtil.getObject(params, "rentto", Integer.class))
																						.setTypeCode(BuildingType)
																						.Build();
		return buildingsearchbuilder;
	}
}
