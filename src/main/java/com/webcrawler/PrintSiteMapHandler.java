package com.webcrawler;

import java.util.Set;

public class PrintSiteMapHandler implements SiteMapHandler
{
    @Override
    public void generate(Set<String> urlSet)
    {
        System.out.println("\n site map \n ----------------------------------------------------------");
        urlSet.iterator().forEachRemaining(System.out::println);

    }
}
