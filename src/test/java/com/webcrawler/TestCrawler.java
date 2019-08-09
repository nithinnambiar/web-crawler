package com.webcrawler;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestCrawler {
    @InjectMocks
    SimpleCrawler crawler;

    @Mock
    SiteMapHandler handler;

    @Mock
    UrlParser parser;

    @Test
    public void shouldSetBaseUrl() throws Exception {
        //Given
        String url = "http://www.google.com";

        //when
        when(parser.parse(anyString())).thenReturn(new ArrayList<>());
        crawler.crawl(url);

        //then
        Assert.assertEquals(url, crawler.getBaseUrl());
    }

    @Test
    public void shouldInvokeParser() throws Exception {
        //Given
        String url = "http://www.google.com";

        //when
        when(parser.parse(anyString())).thenReturn(new ArrayList<>());
        crawler.crawl(url);

        //then
       verify(parser, times(1)).parse(anyString());
    }

    @Test
    public void shouldInvokeSiteMapHandler() throws Exception {
        //Given
        String url = "http://www.google.com";

        //when
        when(parser.parse(anyString())).thenReturn(new ArrayList<>());
        crawler.crawl(url);

        //then
        verify(handler, times(1)).generate(anySet());
    }
}
