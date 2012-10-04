package com.tal.test.book;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private Long id;

    private String title;
    private Float price;

    private String description;

    private Integer nbOfPage;

    private String contentLanguage;

    private List<String> tags = new ArrayList<String>();


    public Book() {
    }

    public Book(String title, Float price, String description, String isbn, Integer nbOfPage) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.nbOfPage = nbOfPage;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getTagsAsString() {
        String s = new String();
        for (String tag : tags) {
            s += tag + ", ";
        }
        if (s.length() > 2)
            return s.substring(0, s.length() - 2);
        else
            return s;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getContentLanguage() {
        return contentLanguage;
    }

    public void setContentLanguage(String contentLanguage) {
        this.contentLanguage = contentLanguage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Book");
        sb.append("{id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", price=").append(price);
        sb.append(", description='").append(description).append('\'');
        sb.append(", nbOfPage=").append(nbOfPage);
        sb.append(", contentLanguage=").append(contentLanguage);
        sb.append(", tags=").append(getTagsAsString());
        sb.append('}');
        return sb.toString();
    }
}