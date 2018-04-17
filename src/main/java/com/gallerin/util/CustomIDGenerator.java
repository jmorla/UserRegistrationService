package com.gallerin.util;

import java.util.UUID;

public class CustomIDGenerator {

	public String genShortId() {
		String id = UUID.randomUUID().toString();
		return id.substring(0, 8);
	}
	
	public static void main(String[] args) {
		String val = new CustomIDGenerator().genShortId();
		System.out.println(val);
	}
}
