package com.headfirst.design.decorator.starbuzz;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
	
	public static void main(String[] args) throws IOException{
		int c;
		try {
			//D:/gitsource/spring3.x/study/chapter2/src.main.resources/test.txt
			InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("src.main.resources/test.txt")));
			while((c=in.read())>=0){
				System.out.print((char)c);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
