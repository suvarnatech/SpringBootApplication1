package com.first.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
//@Scope("singleton")
public class Util {

	public String getId() {
		return UUID.randomUUID().toString();
	}
}
