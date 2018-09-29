package com.shortener.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.validator.constraints.URL;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.shortener.util.Base70NumberSystem;


@RunWith(SpringRunner.class)
@SpringBootTest
class NumberSystemTest {
	

	@Autowired
	private Base70NumberSystem numberSystem;
	

	@Test
	void base70NumberSystemTest1() {
		String expected = "b";
		String actual = numberSystem.getConvertedValue(1);
		assertEquals(expected, actual);
	}
	
	@Test
	void base70NumberSystemTest2() {
		String expected = "ahv";
		String actual = numberSystem.getConvertedValue(583);
		assertEquals(expected, actual);
	}
	
	@Test
	void base70NumberSystemTest3() {
		String expected = "b";
		String actual = numberSystem.getConvertedValue(1);
		assertEquals(expected, actual);
	}
}
