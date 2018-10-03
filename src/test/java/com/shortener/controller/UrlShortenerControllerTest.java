package com.shortener.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.shortener.model.UrlInfo;
import com.shortener.service.UrlShortener;
import com.shortener.service.UrlShortenerImpl;
import com.shortener.util.UnitTestHelper;
import com.shortener.util.UrlValidator;
import com.shortener.util.UrlValidatorImpl;

import org.springframework.http.MediaType;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UrlShortenerController.class, secure = false)
public class UrlShortenerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UrlShortener urlShortener;
	
	@MockBean
	private UrlValidator urlValidator;
	
	@AfterEach
	private void clean() {
		((UrlShortenerImpl)urlShortener).reset();
	}
		
	@Test
	public void shortenUrlTest() throws Exception {
		
		UrlInfo urlInfo = new UrlInfo();
		urlInfo.setOriginalURL("http://www.google.lk");
		
		UrlInfo urlInfoExpected = new UrlInfo();
		urlInfoExpected.setOriginalURL("http://www.google.lk");
		urlInfoExpected.setShortenedURL(null);
		
	    mockMvc.perform(post("/shorten")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(UnitTestHelper.getInstance().objToJSON(urlInfo)) 
                )
                .andExpect(status().isOk())
                .andExpect(content().string(UnitTestHelper.getInstance().objToJSON(urlInfoExpected)));
	
	}

}
