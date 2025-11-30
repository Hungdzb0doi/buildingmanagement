package com.BuildingWeb.Config;



import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;








@Configuration
public class ModelMapperConfig {
	
    @Bean
    public ModelMapper modelmapper() {
    	 ModelMapper modelMapper = new ModelMapper();
    	
    	 
    	    //Chỉ map những trường không null trong DTO
    	    modelMapper.getConfiguration().setSkipNullEnabled(true);

    	    return modelMapper;
    }
}


