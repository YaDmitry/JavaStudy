package lec11_collections.home.execute;

import lec11_collections.home.model.Book;
import lec11_collections.home.model.Library;

import java.util.Collection;

/**
 * Created by dmya on 3/15/2016.
 *
 * Создайте эмуляцию картотеки, в которой содержится следующая информация:
 1. Пользователи библиотеки с информацией о книгах, которые взяты ими.
 2. Все книги библиотеки, упорядоченные по имени автора.
 3. Информации о свободных книгах.
 При этом:
 1. У каждого пользователя может быть несколько книг, но только по одному экземляру конкрутного издания.
 2. На какую-либо книгу может быть очередь из пользователей, ожидающих ее освобождения.
 3. Экземлятор одной книги может быть несколько.
 */

public class Main {

    public static final String ANNA_KARENINA = "Anna Karenina";
    public static final String WAR_AND_PEACE = "War and Peace";
    public static final String YOUTH = "Youth";
    public static final String CHILDHOOD = "Childhood";
    public static final String FATHERS_AND_SONS = "Fathers and Sons";
    public static final String CRIME_AND_PUNISHMENT = "Crime and Punishment";
    public static final String THE_IDIOT = "The Idiot";
    public static final String OBLOMOV = "Oblomov";
    public static final String RUSLAN_AND_LUDMILA = "Ruslan and Ludmila";
    public static final String THE_NOVICE = "The Novice";

    public static void main(String[] args) {

// TODO
// populate library with books

        Library library = createLibrary();
//        User userReader = new User
        Reader();
        library.takeBook(userReader, ANNA_KARENINA);

    }

    public static Library createLibrary() {

        Library library = new Library();

        //<editor-fold desc="Populate library with books">
        library.libraryBooks.add(new Book(ANNA_KARENINA, "Leo Tolstoy"));
        library.libraryBooks.add(new Book(WAR_AND_PEACE, "Leo Tolstoy"));
        library.libraryBooks.add(new Book(YOUTH, "Leo Tolstoy"));
        library.libraryBooks.add(new Book(CHILDHOOD, "Leo Tolstoy"));
        library.libraryBooks.add(new Book(FATHERS_AND_SONS, "Ivan Turgenev"));
        library.libraryBooks.add(new Book(CRIME_AND_PUNISHMENT, "Fyodor Dostoyevsky"));
        library.libraryBooks.add(new Book(THE_IDIOT, "Fyodor Dostoyevsky"));
        library.libraryBooks.add(new Book(OBLOMOV, "Ivan Goncharov"));
        library.libraryBooks.add(new Book(RUSLAN_AND_LUDMILA, "Alexander Pushkin"));
        library.libraryBooks.add(new Book(THE_NOVICE, "Mikhail Lermontov"));
        //</editor-fold>

        library.bookQuantity.put(library.libraryBooks[0]., 10);
        library.bookQuantity.put(b2.bookName, 3);
        library.bookQuantity.put(b3.bookName, 1);
        library.bookQuantity.put(b4.bookName, 10);
        library.bookQuantity.put(b5.bookName, 3);
        library.bookQuantity.put(b6.bookName, 1);
        library.bookQuantity.put(b7.bookName, 10);
        library.bookQuantity.put(b8.bookName, 3);
        library.bookQuantity.put(b9.bookName, 1);
        library.bookQuantity.put(b10.bookName, 1);
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
