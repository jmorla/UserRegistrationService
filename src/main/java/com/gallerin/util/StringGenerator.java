package com.gallerin.util;

import java.util.UUID;

public class StringGenerator {

	
	public static String generateBirdId() {
		return UUID.randomUUID().toString().substring(0, 6);
	}
}
