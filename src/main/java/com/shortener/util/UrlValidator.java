package com.shortener.util;

import java.net.MalformedURLException;
import java.net.URL;

public interface UrlValidator {
    URL validateUrl(String url) throws MalformedURLException;
}
