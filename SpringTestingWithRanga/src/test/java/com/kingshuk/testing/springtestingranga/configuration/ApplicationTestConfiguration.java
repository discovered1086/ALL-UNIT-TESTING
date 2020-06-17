package com.kingshuk.testing.springtestingranga.configuration;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.kingshuk.testing.springtestingranga.service")
public class ApplicationTestConfiguration{
	
	@Bean
	public DozerBeanMapper getDozerBeanMapper() {
		List<String> mappingFiles = new ArrayList<>();
		mappingFiles.add("dozerJdk8Converters.xml");

		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		dozerBeanMapper.setMappingFiles(mappingFiles);
		
		return dozerBeanMapper;
	}
	
}
