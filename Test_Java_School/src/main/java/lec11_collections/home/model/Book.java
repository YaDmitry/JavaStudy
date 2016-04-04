package lec11_collections.home.model;

/**
 * Created by dmya on 3/10/2016.
 */

public class Book {

    final public String bookName; //the book name will be unique for the whole client
    final public String bookAuthor;

    public Book(String bookAuthor, String bookName) {
        this.bookAuthor = bookAuthor;
        this.bookName = bookName;
    }
}
