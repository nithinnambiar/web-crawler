# web-crawler
### A simple java web crawler

### Install

```
mvn clean install

```

### Run

```
java -jar ./target/web-crawler-1.0-SNAPSHOT.jar <url>

```
### Design Notes
 The web crawler is a single threaded command line java application. it takes a website url as input and outputs all reachable urls sequentially.
 It uses a third party library called Jsoup to parse the web pages. Spring library provides the dependency framework to inject the components. A multi-threaded version could be implemented to improve the performance. The SiteMapHandler iimplementation prints the output to the console. An xml version could be added in future.
 

