package com.mia.test;

import com.mia.MvcProcessor;

public class ConnectionTest {

	public static void main(String[] args) {
		
		MvcProcessor mvcProcessor = MvcProcessor.getInstance();	
		int size = mvcProcessor.sampleTest();
		
		System.out.println("size = " + size);
	}
}
