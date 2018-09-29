package com.shortener.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SymbolsTest {
	

	private Symbols symbols;

	@Test
	public void reverseTest() {
		symbols= new Symbols();
		symbols.add("a");
		symbols.add("b");
		symbols.add("c");
		
		String expected = "cba";
		String actual = symbols.reverse();
		assertEquals(expected, actual);
	}

}
