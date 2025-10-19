package com.kk.builder.pattern;

public class Main {

	public static void main(String[] args) {

		User user = new User.UserBuilder("sezgin", "seven", "mail").setAge(30).setPhoneNumber("dasa").build();

		System.out.println(user);
	}
}