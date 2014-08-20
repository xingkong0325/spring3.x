package com.baobaotao.resource;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;

public class FileSourceExample {
	
	public static void main(String[] args){
		try {
			String filePath = "D:/gitsource/spring3.x/study/chapter2/src/main/webapp/WEB-INF/classes/conf/file1.txt";
			
			Resource res1 = new FileSystemResource(filePath);
			
			Resource res2 = new ClassPathResource("sql.sql");
			
			Resource res3 = new ServletContextResource(null, "/WEB-INF/classes/conf/file1.txt");
			
			InputStream ins1 = res1.getInputStream();
			InputStream ins2 = res2.getInputStream();
			
			System.out.println(res1.getFilename());
			System.out.println(res2.getFilename());
			System.out.println(res3.getFilename());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
