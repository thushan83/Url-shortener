package com.shortener.util.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.shortener.util.Symbols;

@RunWith(SpringRunner.class)
@SpringBootTest
class SymbolsTest {   
	
	@Autowired
	Symbols symbols;

	@Test
	void reverseTest() {
		symbols.add("a");
		symbols.add("b");
		symbols.add("c");
		
		String expected = "cba";
		String actual = symbols.reverse();
		assertEquals(expected, actual);
	}
}
 