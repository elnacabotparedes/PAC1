package com.elnacabot.pac1.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookModel {

    public static final List<BookItem> ITEMS = new ArrayList<>();

    static
    {
        BookItem book1 = new BookItem(0, "Title1", "Author1", new Date(), "Description", null );
        BookItem book2 = new BookItem(0, "Title2", "Author2", new Date(), "Description 2", null );

        ITEMS.add(book1);
        ITEMS.add(book2);
    }

    public List<BookItem> getItems()
    {
        return ITEMS;
    }

}
