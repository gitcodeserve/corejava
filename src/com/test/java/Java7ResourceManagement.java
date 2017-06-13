package com.test.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;

public class Java7ResourceManagement {

	public static void main(String[] args) {

		try (MyResource mr = new MyResource()) {
			System.out.println("MyResource created in try-with-resources");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Out of try-catch block.");
	}

	static class MyResource implements AutoCloseable{

		@Override
		public void close() throws Exception {
			System.out.println("Closing MyResource");
		}

	}
}
