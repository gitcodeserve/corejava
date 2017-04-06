package com.test.java;

import java.io.IOException;
import java.nio.charset.Charset;

public class Ploymorphics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "howtodoinjava.com";
        
		byte[] byteArray = name.getBytes();
		
		 
		String str = new String(byteArray);
		String strWithCharset = new String(byteArray, Charset.defaultCharset());
		 
		System.out.println("Original String: "+ name );
		System.out.println("Obtained String: "+ str );
		System.out.println("Obtained String: "+ strWithCharset );

	}
	
	public String str (String str) throws Exception{
		return null;
	};
	
	public int str (int str) throws IOException{
		return 0;
	};

}
