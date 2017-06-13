package com.test.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourceEx {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader(
				"/Users/sahays/WORK/Workspaces/Eclipse_WS/Practice/CoreJava/src/com/test/java/tmp.txt"))) {
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
