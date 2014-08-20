package com.baobaotao.resource;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class PatternResolverTest {
	
	public static void main(String[] args) throws IOException{
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resolver.getResources("classpath*:*.xml");
		for(Resource resource: resources){
			System.out.println(resource.getDescription());
		}
	}

}
