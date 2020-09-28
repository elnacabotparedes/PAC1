package com.elnacabot.pac1.model;


import java.util.Date;

public class BookItem {

    public int id;
    public String title;
    public String author;
    public Date date_publish;
    public String description;
    public String url;

    public BookItem (int id, String title, String author, Date date_publish, String description, String url)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date_publish = date_publish;
        this.description = description;
        this.url = url;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

}
