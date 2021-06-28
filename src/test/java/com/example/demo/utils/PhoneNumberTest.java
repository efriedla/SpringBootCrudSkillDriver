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

	@Test
	@DisplayName("Phone Should not be letters")
	void itShouldNotValidatePhoneNumber(){
		//Given
		String phoneNumber = "asbkj";
		//When
		boolean isValid =  underTest.test(phoneNumber);
		//Then
		assertThat(isValid).isFalse();
	}

	@Test
	@DisplayName("Ultimate test for phoneNumbers")
	void itShouldValidatePhoneNumber(){
		//Given
		String phoneNumber = "1-234-567-8901";
		//When
		boolean isValid =  underTest.test(phoneNumber);
		//Then
		assertThat(isValid).isTrue();
	}



	// matches
	// "1-234-567-8901",
	//"1-234-567-8901 x1234",
	//"1-234-567-8901 ext1234",
	//"1 (234) 567-8901",
	//"1.234.567.8901",
	//"1/234/567/8901",
	//"12345678901",
	//"not a phone number"
	@ParameterizedTest
	@CsvSource({
			"1-234-567-8901,true",
			"1-234-567-8901 x1234,true",
			"1-234-567-8901 ext1234,true",
			"1-123-1,false",
			"1 (234) 567-8901,true",
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
