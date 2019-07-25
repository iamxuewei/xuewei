package com.xuewei.util;


import java.util.UUID;

public class UUIDFactory {

	public static String getUUIDStr() {
		UUID localUUID = UUID.randomUUID();
		String str = localUUID.toString();
		str = str.replaceAll("[-]", "");
		return str.toUpperCase();
	}



}
