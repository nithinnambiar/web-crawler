package com.webcrawler;

import com.webcrawler.util.UrlValidator;
import org.junit.Assert;
import org.junit.Test;

public class TestUrlUtil {

    @Test
    public void shouldReturnTrueWhenUrlIsValid()
    {
        String url="http://www.google.com";
        Assert.assertTrue(UrlValidator.isValidUrl(url));
    }

    @Test
    public void shouldReturnFalseWhenUrlIsValid()
    {
        String url="htts://wwww.gprs.coms";
        Assert.assertFalse(UrlValidator.isValidUrl(url));
    }
}
