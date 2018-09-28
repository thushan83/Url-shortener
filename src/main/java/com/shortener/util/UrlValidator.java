package com.shortener.util;

import java.net.MalformedURLException;
import java.net.URL;

public interface UrlValidator {
    URL getURL(String url);
}
