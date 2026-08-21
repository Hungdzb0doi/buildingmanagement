package com.BuildingWeb.Service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.BuildingWeb.DTO.response.BuildingStatisticDTO;
import com.BuildingWeb.Entity.BuildingTypeEntity;
import com.BuildingWeb.Entity.RentAreaEntity;
import com.BuildingWeb.Repository.BuildingTypeRepository;
import com.BuildingWeb.Repository.RentAreaRepository;
import com.BuildingWeb.Utils.DifferentUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BuildingWeb.Builder.BuildingSearchBuilder;
import com.BuildingWeb.Converter.BuildingDTOConverter;
import com.BuildingWeb.Converter.BuildingSearchBuilderConverter;
import com.BuildingWeb.DTO.response.BuildingDTO;
import com.BuildingWeb.DTO.request.RequestBuildingDTO;
import com.BuildingWeb.Entity.BuildingEntity;
import com.BuildingWeb.Entity.DistrictEntity;
import com.BuildingWeb.Repository.BuildingRepository;
import com.BuildingWeb.Repository.DistrictRepository;
import com.BuildingWeb.Service.BuildingService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	BuildingRepository BR;
	@Autowired
	DistrictRepository DR;
	@Autowired
	BuildingDTOConverter BDTOC;
	@Autowired
	BuildingSearchBuilderConverter BSBC;
    @Autowired
    RentAreaRepository RR;
    @Autowired
    BuildingTypeRepository BTR;
	@Autowired
	ModelMapper modelmapper;
	@Override
public List<BuildingDTO> FindAll(HashMap<String,Object> params,List<String> BuildingType){
	BuildingSearchBuilder buildingsearchbuilder=	BSBC.ToBuildingSearchBuilder(params, BuildingType);
	List<BuildingEntity> RequestBuildingEntity= BR.FindAll(buildingsearchbuilder);
	List<BuildingDTO> ListBuilding =new ArrayList<>();
	
	for(BuildingEntity bett : RequestBuildingEntity) {
	    
		ListBuilding.add(BDTOC.ToBuildingDTO(bett));
		}
	
		
	
	
	return ListBuilding.stream().distinct().collect(Collectors.toList());
}
	
	public void InsertBuilding(RequestBuildingDTO requestbuildingdto) {
		BuildingEntity buildingentity=modelmapper.map(requestbuildingdto, BuildingEntity.class);
		DistrictEntity districtentity= new DistrictEntity();
		districtentity.setIdDistrict((long) requestbuildingdto.getIdDistrict());
		buildingentity.setDistrict(districtentity);
		BuildingEntity savedBuildingEntity=BR.save(buildingentity);
        List<RentAreaEntity> listRentAreaEntity = new ArrayList<>();
        if(requestbuildingdto.getRentArea()!=null&&requestbuildingdto.getRentArea()!="") {
            String[] areas=requestbuildingdto.getRentArea().split(",");
            int sumrentarea=0;
            for(String a : areas ){
                sumrentarea+=Integer.parseInt(a);
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setArea(Integer.parseInt(a));
                rentAreaEntity.setBuilding(savedBuildingEntity);
                listRentAreaEntity.add(rentAreaEntity);
            }
            if (requestbuildingdto.getFloorArea() != null) {
                if (sumrentarea > requestbuildingdto.getFloorArea()) {
                    throw new RuntimeException("Lỗi: Tổng diện tích thuê (" + sumrentarea + " m2) phải nhỏ hơn hoặc bằng diện tích sàn (" + requestbuildingdto.getFloorArea() + " m2)!");
                }
            }
            RR.saveAll(listRentAreaEntity);
        }
        List<BuildingTypeEntity> listBuildingTypeEntity = new ArrayList<>();
        if(requestbuildingdto.getTypeCode()!=null&&!requestbuildingdto.getTypeCode().isEmpty()){
            for(String t : requestbuildingdto.getTypeCode()){
                BuildingTypeEntity buildingTypeEntity = new BuildingTypeEntity();
                buildingTypeEntity.setBuilding(savedBuildingEntity);
                buildingTypeEntity.setCode(t);
                buildingTypeEntity.setBuildingTypeName(DifferentUtil.getBuildingTypeNameByCode(t));
                listBuildingTypeEntity.add(buildingTypeEntity);
            }
            BTR.saveAll(listBuildingTypeEntity);
        }
	}
    public RequestBuildingDTO FindById(Long Id){
        BuildingEntity buildingEntity = BR.findById(Id).get();
        RequestBuildingDTO requestBuildingDTO=modelmapper.map(buildingEntity, RequestBuildingDTO.class);
        if(buildingEntity.getDistrict()!=null){
        requestBuildingDTO.setIdDistrict(buildingEntity.getDistrict().getIdDistrict().intValue());
        }

        if(buildingEntity.getRentArea()!=null&&!buildingEntity.getRentArea().isEmpty()){
            List<RentAreaEntity> listRentAreaEntity = buildingEntity.getRentArea();
            List<String> rentareas = new ArrayList<>();
            for(RentAreaEntity r : listRentAreaEntity){
                rentareas.add(r.getArea().toString());
            }
            requestBuildingDTO.setRentArea(String.join(",",rentareas));
        }
        if(buildingEntity.getBuildingType()!=null&&!buildingEntity.getBuildingType().isEmpty()){
            List<BuildingTypeEntity> listBuildingTypeEntity = buildingEntity.getBuildingType();
            List<String> buildingTypes = new ArrayList<>();
            for( BuildingTypeEntity t : listBuildingTypeEntity){
                buildingTypes.add(t.getCode());
            }

            requestBuildingDTO.setTypeCode(buildingTypes);
        }
        return requestBuildingDTO;
    }
	public void UpdateBuilding(RequestBuildingDTO requestbuildingdto) {
		BuildingEntity buildingentity=BR.findById(requestbuildingdto.getIdBuilding()).get();
		BeanUtils.copyProperties(requestbuildingdto, buildingentity,"District");
		DistrictEntity districtentity= DR.findById((long) requestbuildingdto.getIdDistrict()).get();
		buildingentity.setDistrict(districtentity);
        if(requestbuildingdto.getRentArea()!=null&&!requestbuildingdto.getRentArea().equals("")){
            RR.deleteBybuilding_idBuilding(buildingentity.getIdBuilding());
            List<RentAreaEntity> listRentAreaEntity = new ArrayList<>();
            String[] rentareas = requestbuildingdto.getRentArea().split(",");
            int sumrentarea=0;
            for(String r : rentareas){
                sumrentarea+=Integer.parseInt(r);
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setBuilding(buildingentity);
                rentAreaEntity.setArea(Integer.parseInt(r));
                listRentAreaEntity.add(rentAreaEntity);
            }
            if (requestbuildingdto.getFloorArea() != null) {
                if (sumrentarea > requestbuildingdto.getFloorArea()) {
                    throw new RuntimeException("Lỗi: Tổng diện tích thuê (" + sumrentarea + " m2) phải nhỏ hơn hoặc bằng diện tích sàn (" + requestbuildingdto.getFloorArea() + " m2)!");
                }
            }
            RR.saveAll(listRentAreaEntity);
        }
        if(requestbuildingdto.getTypeCode()!=null&&!requestbuildingdto.getTypeCode().isEmpty()){
            BTR.deleteBybuilding_idBuilding(buildingentity.getIdBuilding());
            List<BuildingTypeEntity> listBuildingTypeEntity = new ArrayList<>();
            for(String t : requestbuildingdto.getTypeCode()){
                BuildingTypeEntity buildingTypeEntity = new BuildingTypeEntity();
                buildingTypeEntity.setCode(t);
                buildingTypeEntity.setBuildingTypeName(DifferentUtil.getBuildingTypeNameByCode(t));
                buildingTypeEntity.setBuilding(buildingentity);
                listBuildingTypeEntity.add(buildingTypeEntity);
            }
            BTR.saveAll(listBuildingTypeEntity);
        }
		BR.save(buildingentity);
	}
	public void DeleteBuilding(Long id) {
		BR.deleteById(id);;
	}
	public void DeleteBuildings(Long[] id) {
		BR.deleteByIdBuildingIn(id);;
	}
    @Override
    public List<BuildingStatisticDTO> getAvailableAreaStatistic() {


        List<Object[]> rawData = BR.getAvailableAreaByDistrictAndClass();


        Map<String, BuildingStatisticDTO> mapStatistic = new HashMap<>();


        for (Object[] row : rawData) {
            DistrictEntity districtEntity = (DistrictEntity) row[0];


            String district = districtEntity.getDistrictName();
            String buildingClass = (String) row[1];


            Long area = 0L;
            if (row[2] != null) {
                area = ((Number) row[2]).longValue();
            }


            BuildingStatisticDTO dto = mapStatistic.getOrDefault(district, new BuildingStatisticDTO());
            dto.setDistrict(district);


            if (buildingClass != null) {
                if (buildingClass.equalsIgnoreCase("A")) {
                    Long current = dto.getTotalAreaClassA();
                    dto.setTotalAreaClassA((current == null ? 0L : current) + area);

                } else if (buildingClass.equalsIgnoreCase("B")) {
                    Long current = dto.getTotalAreaClassB();
                    dto.setTotalAreaClassB((current == null ? 0L : current) + area);

                } else if (buildingClass.equalsIgnoreCase("C")) {
                    Long current = dto.getTotalAreaClassC();
                    dto.setTotalAreaClassC((current == null ? 0L : current) + area);
                }

            }


            mapStatistic.put(district, dto);
        }


        return new ArrayList<>(mapStatistic.values());
    }
}
