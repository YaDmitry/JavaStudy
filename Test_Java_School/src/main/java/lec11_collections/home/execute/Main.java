package lec11_collections.home.execute;

import lec11_collections.home.model.Book;
import lec11_collections.home.model.Library;
import lec11_collections.home.model.User;

/**
 * Created by dmya on 3/15/2016.
 * <p>
 * Создайте эмуляцию картотеки, в которой содержится следующая информация:
 * 1. Пользователи библиотеки с информацией о книгах, которые взяты ими.
 * 2. Все книги библиотеки, упорядоченные по имени автора.
 * 3. Информации о свободных книгах.
 * При этом:
 * 1. У каждого пользователя может быть несколько книг, но только по одному экземляру конкрутного издания.
 * 2. На какую-либо книгу может быть очередь из пользователей, ожидающих ее освобождения.
 * 3. Экземлятор одной книги может быть несколько.
 */

public class Main {

//    TODO
//сделать метод который достает все КНИГИ

    //<editor-fold desc="final Strings of library books">
    public static final String LEO_TOLSTOY = "Лев Толстой";
    public static final String IVAN_TURGENEV = "Иван Тургенев";
    public static final String FYODOR_DOSTOYEVSKY = "Федор Достоевский";
    public static final String IVAN_GONCHAROV = "Иван Гончаров";
    public static final String ALEXANDER_PUSHKIN = "Александр Пушкин";
    public static final String ANNA_KARENINA = "Анна Каренина";
    public static final String WAR_AND_PEACE = "Война и Мир";
    public static final String YOUTH = "Юность";
    public static final String CHILDHOOD = "Детство";
    public static final String FATHERS_AND_SONS = "Отцы и Дети";
    public static final String CRIME_AND_PUNISHMENT = "Преступление и Наказание";
    public static final String THE_IDIOT = "Идиот";
    public static final String OBLOMOV = "Обломов";
    public static final String RUSLAN_AND_LUDMILA = "Руслан и Людмила";
    //</editor-fold>

    public static void main(String[] args) {

        Library library = createLibrary();

        User user1 = new User("Alexey");
        User user2 = new User("Dmitry");
        User user3 = new User("Maria");

        System.out.println("КНИГИ НАШЕЙ БИБЛИОТЕКИ:");
        library.printAllBooks();
        System.out.println("-----------------------------------------");

        library.takeBook(user1, FATHERS_AND_SONS);
        library.takeBook(user2, WAR_AND_PEACE);
        library.takeBook(user1, "Программирование для Чайников");
        library.takeBook(user2, FATHERS_AND_SONS);
        library.takeBook(user1, WAR_AND_PEACE);


        System.out.println("----");
        System.out.println("Books: ");
//        library.printAllBooks();
        System.out.println("Users: "); //user + book
        System.out.println("Queue of books: "); //user + book

    }

    public static Library createLibrary() {

        Library library = new Library();

        //<editor-fold desc="Create library books">
        Book b1 = new Book(LEO_TOLSTOY, ANNA_KARENINA);
        Book b2 = new Book(LEO_TOLSTOY, WAR_AND_PEACE);
        Book b3 = new Book(LEO_TOLSTOY, YOUTH);
        Book b4 = new Book(LEO_TOLSTOY, CHILDHOOD);
        Book b5 = new Book(IVAN_TURGENEV, FATHERS_AND_SONS);
        Book b6 = new Book(FYODOR_DOSTOYEVSKY, CRIME_AND_PUNISHMENT);
        Book b7 = new Book(FYODOR_DOSTOYEVSKY, THE_IDIOT);
        Book b8 = new Book(IVAN_GONCHAROV, OBLOMOV);
        Book b9 = new Book(ALEXANDER_PUSHKIN, RUSLAN_AND_LUDMILA);
        //</editor-fold>

        //<editor-fold desc="Populate library with books">
        library.libraryBooks.add(b1);
        library.libraryBooks.add(b2);
        library.libraryBooks.add(b3);
        library.libraryBooks.add(b4);
        library.libraryBooks.add(b5);
        library.libraryBooks.add(b6);
        library.libraryBooks.add(b7);
        library.libraryBooks.add(b8);
        library.libraryBooks.add(b9);
        //</editor-fold>

        //<editor-fold desc="Give information about available books">
        library.bookQty.put(b1.bookName, 2);
        library.bookQty.put(b2.bookName, 4);
        library.bookQty.put(b3.bookName, 0);
        library.bookQty.put(b4.bookName, 11);
        library.bookQty.put(b5.bookName, 1);
        library.bookQty.put(b6.bookName, 6);
        library.bookQty.put(b7.bookName, 0);
        library.bookQty.put(b8.bookName, 3);
        library.bookQty.put(b9.bookName, 1);
        //</editor-fold>

        return library;
    }
}
