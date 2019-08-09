package com.webcrawler;

import com.webcrawler.config.AppConfig;
import com.webcrawler.util.UrlValidator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args)
    {
        String url=args[0];

        if(!UrlValidator.isValidUrl(url)) {
            System.out.println("Please specify a valid url");
            return;
        }

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        Crawler crawler= ctx.getBean(Crawler.class);
        crawler.crawl(url);

    }
}
