package com.example.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class s42893 {

  private static HashMap<String, Page> maps;
  private static Pattern urlPattern = Pattern.compile("<meta property=\"og:url\" content=\"https://(\\S*)\"/>");
  private static Pattern outLinkPattern = Pattern.compile("<a href=\"https://(\\S*)\">");

  public static int solution(String word, String[] pages) {
    word = word.toLowerCase();
    maps = new HashMap<>();

    for (int i = 0; i < pages.length; i++) {
      Page now = reorganizeString(pages[i], i, word);

      double outScore = now.basicScore / now.outLinks.size();
      for (String outLink : now.outLinks) {
        if (outLink.equals(now.url)) {
          continue;
        }
        if (!maps.containsKey(outLink)) {
          maps.put(outLink, new Page(-1, outLink, 0, new ArrayList<>(), 0));
        }
        maps.get(outLink).outScore += outScore;
      }
    }

    double[] scores = new double[maps.size()];
    int answer = 0;
    double maxScore = 0;
    for (Page page : maps.values()) {
      if (page.index == -1) {
        continue;
      }
      scores[page.index] = page.basicScore + page.outScore;
    }

    for (int i = 0; i < scores.length; i++) {
      if (maxScore < scores[i]) {
        maxScore = scores[i];
        answer = i;
      }
    }

    return answer;
  }

  private static Page reorganizeString(String page, int index, String word) {
    int basicScore = getBasicScore(page, word);

    Matcher urlMatcher = urlPattern.matcher(page);
    String url = "";
    while (urlMatcher.find()) {
      url = getUrl(urlMatcher.group());
    }

    Matcher outLineMatcher = outLinkPattern.matcher(page);
    ArrayList<String> outLinks = new ArrayList<>();

    while (outLineMatcher.find()) {
      String outLink = getOutLink(outLineMatcher.group());
      outLinks.add(outLink);
    }

    if (maps.containsKey(url)) {
      maps.get(url).index = index;
      maps.get(url).basicScore = basicScore;
      maps.get(url).outLinks = outLinks;
    } else {
      maps.put(url, new Page(index, url, basicScore, outLinks, 0));
    }

    return maps.get(url);
  }

  private static String getUrl(String metaString) {
    return metaString
        .replaceAll("<meta property=\"og:url\" content=\"", "")
        .replaceAll("\"/>", "");
  }

  private static String getOutLink(String hrefString) {
    return hrefString
        .replaceAll("<a href=\"", "")
        .replaceAll("\">", "");
  }

  private static int getBasicScore(String page, String word) {
    int count = 0;
    String body = page
        .split("<body>")[1]
        .split("</body>")[0]
        .toLowerCase();

    body = body.replaceAll("<a href=\"https://(\\S*)\">", " ");
    body = body.replaceAll("</a>", " ");
    for (int i = 0; i < body.length(); i++) {
      if (body.charAt(i) > 96 && body.charAt(i) < 123) {
        continue;
      }
      body = body.replace(body.charAt(i), ' ');
    }

    String[] words = body.split(" ");

    for (String now : words) {
      if (now.equals(word)) {//완전히 일치
        count++;
      }
    }
    return count;
  }

  private static class Page {

    int index;
    String url;
    double basicScore;
    ArrayList<String> outLinks;
    double outScore;

    public Page(int index, String url, double basicScore, ArrayList<String> outLinks,
        double outScore) {
      this.index = index;
      this.url = url;
      this.basicScore = basicScore;
      this.outLinks = outLinks;
      this.outScore = outScore;
    }

  }

}
