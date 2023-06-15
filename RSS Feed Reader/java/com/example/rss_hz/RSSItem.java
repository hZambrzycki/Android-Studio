package com.example.rss_hz;

public class RSSItem {

    public String title;
    public String link;
    public String description;
    public String pubdate;
    public String guid;
    public String imageUrl;
    public RSSItem(String title, String link, String description, String pubdate, String guid, String imageUrl) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubdate = pubdate;
        this.guid = guid;
        this.imageUrl = imageUrl;
    }
}
