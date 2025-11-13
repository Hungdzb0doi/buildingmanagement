package com.BuildingWeb.Config;

import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.BuildingWeb.DTO.RequestBuildingDTO;
import com.BuildingWeb.Entity.BuildingEntity;



@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelmapper() {
    	 ModelMapper modelMapper = new ModelMapper();

    	    // Tạo type map rỗng trước → KHÔNG implicit map
    	    modelMapper.createTypeMap(RequestBuildingDTO.class, BuildingEntity.class)
    	               .setPreConverter(context -> {
    	                   // Bỏ qua district
    	                   context.getDestination().setDistrict(null);
    	                   return context.getDestination();
    	               });
    	    //Chỉ map những trường không null trong DTO
    	    modelMapper.getConfiguration().setSkipNullEnabled(true);

    	    return modelMapper;
    }
}


