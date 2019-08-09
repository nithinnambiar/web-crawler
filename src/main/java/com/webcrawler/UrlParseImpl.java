package com.webcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class UrlParseImpl implements UrlParser {
    @Override
    public List<String> parse(String url) throws IOException {
        System.out.println("processing.. " + url);
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a");
        return links.stream().map(link -> link.attr("abs:href")).collect(Collectors.toList());
    }
}
