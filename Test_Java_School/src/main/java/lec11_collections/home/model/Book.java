package lec11_collections.home.model;

/**
 * Created by dmya on 3/10/2016.
 */
public class Book {

    public String bookName; //the book name will be unique for the whole library
    public String bookAuthor;

    public Book(String bookName, String bookAuthor) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }
}
