package com.example.recyclerview_article_scroll;

public class Article {

    private int image;
    private String title;
    private String section;
    private int logo;
    private String body;
    private String author;
    private boolean expanded;

    public Article(int image, String title, String section, int logo, String body, String author) {
        this.image = image;
        this.title = title;
        this.section = section;
        this.logo = logo;
        this.body = body;
        this.author = author;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public int getLogo() {
        return logo;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }
}
