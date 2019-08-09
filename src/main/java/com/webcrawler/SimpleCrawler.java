package com.webcrawler;


import com.webcrawler.util.UrlValidator;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public final class SimpleCrawler implements Crawler {
    private final LinkedList<String> urlList = new LinkedList<>();

    private final Set<String> visitedUrls = new HashSet<>();

    private final Set<String> exceptionUrls = new HashSet<>();

    private final SiteMapHandler handler;

    private final UrlParser urlParser;

    private String baseUrl;

    public SimpleCrawler(SiteMapHandler siteMapHandler, UrlParser urlParser) {
        this.handler = siteMapHandler;
        this.urlParser = urlParser;
    }

    @Override
    public void crawl(String url) {

        baseUrl = url;
        add(url);
        int count = 0;

        while (!urlList.isEmpty()) {
            String urlToVisit = urlList.remove();
            count++;
            try {

                process(urlToVisit);
                addVisitedUrl(urlToVisit);

            } catch (Exception ex) {

                this.addErrorUrl(urlToVisit);
                System.out.println("Error processing " + urlToVisit);

            }

        }
        System.out.println("processing complete with urls:" + count);
        handler.generate(this.visitedUrls);

    }

    @Override
    public String getBaseUrl() {
        return this.baseUrl;
    }

    private void add(String url) {
        urlList.add(url);
    }

    private void addVisitedUrl(String url) {
        this.visitedUrls.add(url);
    }

    private void addErrorUrl(String url) {
        this.exceptionUrls.add(url);
    }

    private void process(String url) throws IOException {

        if (isInternalUrl(url) && notVisited(url) && UrlValidator.canBeParsed(url)) {
            List<String> list = urlParser.parse(url);
            urlList.addAll(list);
        }
    }

    private boolean isInternalUrl(String url) {
        return url.contains(baseUrl);
    }

    private boolean notVisited(String url) {
        return !visitedUrls.contains(url);
    }

}
