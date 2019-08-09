package com.webcrawler.config;

import com.webcrawler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Crawler createCrawler()
    {
        return new SimpleCrawler(createSiteMapHandler(), createUrlParser());
    }

    @Bean
    SiteMapHandler createSiteMapHandler()
    {
        return new PrintSiteMapHandler();
    }

    @Bean
    public UrlParser createUrlParser()
    {
        return new UrlParseImpl();
    }

}
