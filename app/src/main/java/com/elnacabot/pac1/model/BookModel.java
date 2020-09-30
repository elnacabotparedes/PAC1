package com.elnacabot.pac1.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookModel {

    public static final List<BookItem> ITEMS = new ArrayList<>();

    static
    {
        BookItem book1 = new BookItem(0, "Title2", "Author3", new Date(), "Description", "book" );
        BookItem book2 = new BookItem(0, "Title3", "Author5", new Date(), "Description 2", "book1" );
        BookItem book3 = new BookItem(0, "Title5", "Author2", new Date(), "Description 3", "book2" );
        BookItem book4 = new BookItem(0, "Title1", "Author4", new Date(), "Description 4", "book3" );
        BookItem book5 = new BookItem(0, "Title4", "Author6", new Date(), "Description 5", "book4" );
        BookItem book6 = new BookItem(0, "Title6", "Author1", new Date(), "Description 6", "book5" );
        BookItem book7 = new BookItem(0, "Title9", "Author9", new Date(), "Description 7", "book4" );
        BookItem book8 = new BookItem(0, "Title8", "Author7", new Date(), "Description 8", "book1" );
        BookItem book9 = new BookItem(0, "Title7", "Author8", new Date(), "Description 9", "book2" );

        ITEMS.add(book1);
        ITEMS.add(book2);
        ITEMS.add(book3);
        ITEMS.add(book4);
        ITEMS.add(book5);
        ITEMS.add(book6);
        ITEMS.add(book7);
        ITEMS.add(book8);
        ITEMS.add(book9);
    }

    public List<BookItem> getItems()
    {
        return ITEMS;
    }
}
