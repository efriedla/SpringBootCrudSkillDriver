package com.example.demo.utils;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements Predicate<String> {

	@Override
	public boolean test(String phoneNumber) {
		Matcher result = Pattern.compile(
				"1?\\W*([2-9][0-8][0-9])\\W*([2-9][0-9]{2})\\W*([0-9]{4})(\\se?x?t?(\\d*))?"
		).matcher(phoneNumber);
		return result.find();
	}
}
