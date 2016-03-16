package lec11_collections.home.model;

/**
 * Created by dmya on 3/15/2016.
 */
public class BookRequest {
    User user;
    Book book;

    public BookRequest(User user, Book book) {
        this.user = user;
        this.book = book;
    }
}
