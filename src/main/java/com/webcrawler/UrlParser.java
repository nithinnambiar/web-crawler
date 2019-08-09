package com.webcrawler;

import java.io.IOException;
import java.util.List;

public interface UrlParser {

    public List<String> parse(String url) throws IOException;
}
