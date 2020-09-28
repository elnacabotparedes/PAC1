package com.elnacabot.pac1.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookModel {

    public static final List<BookItem> ITEMS = new ArrayList<>();

    static
    {
        BookItem book1 = new BookItem(0, "Title2", "Author3", new Date(), "Description", null );
        BookItem book2 = new BookItem(0, "Title3", "Author5", new Date(), "Description 2", null );
        BookItem book3 = new BookItem(0, "Title5", "Author2", new Date(), "Description 2", null );
        BookItem book4 = new BookItem(0, "Title1", "Author4", new Date(), "Description 2", null );
        BookItem book5 = new BookItem(0, "Title4", "Author6", new Date(), "Description 2", null );
        BookItem book6 = new BookItem(0, "Title6", "Author1", new Date(), "Description 2", null );

        ITEMS.add(book1);
        ITEMS.add(book2);
        ITEMS.add(book3);
        ITEMS.add(book4);
        ITEMS.add(book5);
        ITEMS.add(book6);
    }

    public List<BookItem> getItems()
    {
        return ITEMS;
    }
}
