package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HackerNews {
    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_URL_TEMPLATE = "https://hacker-news.firebaseio.com/v0/item/%d.json";
    private final static Logger LOGGER = LogManager.getLogger();

//    public static void main(String[] args) {
//        HackerNews hackerNews = new HackerNews();
//        long[] topStories = hackerNews.hackerNewsTopStories();
//        System.out.println(Arrays.toString(topStories));
//        String newsTitle = hackerNews.getNewsById(37570037);
//        System.out.println(newsTitle);
//    }

    public long[] hackerNewsTopStories() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(TOP_STORIES_URL))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            String[] ids = responseBody.substring(1, responseBody.length() - 1).split(",");
            long[] storyIds = new long[ids.length];
            for (int i = 0; i < ids.length; i++) {
                storyIds[i] = Long.parseLong(ids[i]);
            }
            return storyIds;
        } catch (IOException | InterruptedException e) {
            LOGGER.info(e.getMessage());
            return new long[0];
        }
    }

    public String getNewsById(long id) {
        String itemUrl = String.format(ITEM_URL_TEMPLATE, id);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(itemUrl))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            Pattern pattern = Pattern.compile("\"title\":\"(.+?)\"");
            Matcher matcher = pattern.matcher(responseBody);
            if (matcher.find()) {
                return matcher.group(1);
            } else {
                return "";
            }
        } catch (IOException | InterruptedException e) {
            LOGGER.info(e.getMessage());
            return "";
        }
    }
}
