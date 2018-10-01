package com.shortener.controller;

import java.net.URL;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.shortener.model.UrlInfo;
import com.shortener.service.UrlShortener;
import com.shortener.util.UrlValidator;

@RestController
public class UrlShortenerController {
	
	@Autowired
	UrlShortener urlShortner;
	
	@Autowired
	UrlValidator urlValidator;
	
	@RequestMapping(value = "/shorten", method = RequestMethod.POST)
	public UrlInfo shortedUrl(@RequestBody UrlInfo urlInfo) {
		URL validURL = urlValidator.getURL(urlInfo.getOriginalURL());
		if(validURL != null) {
			urlInfo.setShortenedURL(urlShortner.shortenUrl(validURL));
			return urlInfo;
		}else {
			return urlInfo;
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public RedirectView gotoUrl(@PathVariable String id) {
		String originalUrl = urlShortner.getActualUrl(id);
		return new RedirectView(originalUrl);
	}
}
