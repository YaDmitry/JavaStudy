package lec11_collections.home.execute;

import lec11_collections.home.model.Book;
import lec11_collections.home.model.Library;
import lec11_collections.home.model.UserReader;

import java.util.Collection;

/**
 * Created by dmya on 3/15/2016.
 */
public class Main {

    public static final String ГОРЯ_ОТ_УМА = "ГоряОтУма";

    public static void main(String[] args) {

// TODO
// populate library with books

        Library library = createLibrary();
        UserReader userReader = new User
        Reader();
        library.takeBook(userReader, ГОРЯ_ОТ_УМА);

    }

    public static Library createLibrary() {

        Library library = new Library();
        Book b1 = new Book(ГОРЯ_ОТ_УМА, "Достоевский");
        Book b2 = new Book("Идиот", "Достоевский");
        Book b3 = new Book("ВойнаИМир", "Толстой");
        library.libraryBooks.add(b1);
        library.libraryBooks.add(b2);
        library.libraryBooks.add(b3);
        library.bookQuantity.put(b1.bookName, 10);
        library.bookQuantity.put(b2.bookName, 3);
        library.bookQuantity.put(b3.bookName, 1);
        return library;
    }

    public static Book findBookByName(Collection<Book> books, String bookName) {
        for (Book book : books) {
            if (bookName.equals(book.bookName))
                return book;
        }
        System.out.println("Requested book was not found: " + bookName);
        return null;
    }


}
