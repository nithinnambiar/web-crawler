package com.webcrawler.util;

import java.net.URL;

public class UrlValidator {

    public static boolean isValidUrl(String urlString)
    {
        try {
            new URL(urlString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean canBeParsed(String url)
    {
        if (url.endsWith(".jpeg")) {
            return false;
        }
        if (url.endsWith(".pdf")) {
            return false;
        }
        if (url.endsWith(".png")) {
            return false;
        }
        if (url.endsWith(".gif")) {
            return false;
        }
        if (url.endsWith(".swf")) {
            return false;
        }
        if (url.endsWith(".jpg")) {
            return false;
        }

        return url.startsWith("http://") || url.startsWith("https://");
    }
}
