package lec11_collections.home.model;

import java.util.Comparator;

/**
 * Created by dmya on 3/16/2016.
 */
public class BookComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Book book1 = (Book) o1;
        Book book2 = (Book) o2;
        return book1.bookAuthor.compareTo(book2.bookAuthor);
    }
}
