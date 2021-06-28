package com.example.demo.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PhoneNumberTest {

	private PhoneNumberValidator underTest;

	@BeforeEach
	void setUp(){
		underTest = new PhoneNumberValidator();
	}

	@ParameterizedTest
	@CsvSource({
			"1-234-567-8901,true",
			"1-234-567-8901 x1234,true",
			"1-234-567-8901 ext1234,true",
			"1-123-1,false",
			"1 (234) 567-8901,true",
			"abksdfj,false",
			"1.234.567.8901,true",
			"1/234/567/8901,true",
			"12345678901,true",
	})
	void itShouldValidatePhoneNumberAll(String inputPhoneNumber, boolean expected){
		//When
		boolean isValid =  underTest.test(inputPhoneNumber);
		//Then
		assertThat(isValid).isEqualTo(expected);
	}


}
