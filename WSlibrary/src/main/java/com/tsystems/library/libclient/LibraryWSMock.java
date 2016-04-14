package com.tsystems.library.libclient;

import com.tsystems.library.libservice.*;

import java.util.*;

import static com.tsystems.library.libclient.CommonConstants.*;

/**
 * Created by dyaprint on 07.04.2016.
 */
public class LibraryWSMock implements LibraryWS {

    // Initialize collections
    Map<String, User> usersMap = new TreeMap<>();
    List<Author> authors = new ArrayList<>();
    List<Book> books = new ArrayList<>();
    Queue<IsWaiting> waitingQueue = new ArrayDeque<>();

    private static long idCounter = 0;

    public static synchronized String createID() {
        return String.valueOf(idCounter++);
    }

    public LibraryWSMock() {
        // Add basic set of Users
        addUser("Name1", "Surname1");
        addUser("Name2", "Surname2");
        addUser("Name3", "Surname3");
        addUser("Name4", "Surname4");
        // create Authors
        addAuthor(LEO, TOLSTOY);
        addAuthor(IVAN, TURGENEV);
        addAuthor(FYODOR, DOSTOYEVSKY);
        addAuthor(ALEXANDER, PUSHKIN);
        // create Books
        addBook(4, authors.get(0), ANNA_KARENINA);
        addBook(6, authors.get(0), WAR_AND_PEACE);
        addBook(0, authors.get(0), YOUTH);
        addBook(11, authors.get(0), CHILDHOOD);
        addBook(1, authors.get(1), FATHERS_AND_SONS);
        addBook(2, authors.get(2), CRIME_AND_PUNISHMENT);
        addBook(0, authors.get(2), THE_IDIOT);
        addBook(2, authors.get(3), RUSLAN_AND_LUDMILA);
    }

    @Override
    public boolean addUser(String name, String surname) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        // generate id
        String id = createID();
        usersMap.put(id, user);
        return true;
    }

    @Override
    public List<String> getUserIds() {
        List<String> listID = new ArrayList<>();
        for (String userId : usersMap.keySet()) {
            listID.add(userId);
        }
        return listID;
    }

    @Override
    public User getUser(String id) {
        return usersMap.get(id);
    }

    public boolean addBook(int amount, Author author, String title) {
        Book book = new Book();
        book.setAmount(amount);
        book.setAuthor(author);
        book.setTitle(title);
        books.add(book);
        return true;
    }

    @Override
    public List<Book> getBooks(Author author) {
        List<Book> bookList = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    @Override
    public void takeBook(User user, Book takenBook) {
        for (Book book : books) {
            if (book.equals(takenBook)) {
                if (book.getAmount() > 0) {
                    book.setAmount(book.getAmount() - 1);
                } else {
                    waitingQueue.add(new IsWaiting(user, takenBook));
                }
            }
        }
    }

    @Override
    public void returnBook(User user, Book returnedBook) {
        for (Book book : books) {
            if (book.equals(returnedBook)) {
                book.setAmount(book.getAmount() + 1);
            }
        }
    }

    @Override
    public Book getBook(Book gotBook) {
        for (Book book : books) {
            if (book.equals(gotBook))
                return book;
        }
        return null;
    }

    public boolean addAuthor(String name, String surname) {
        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);
        authors.add(author);
        return true;
    }

    @Override
    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public boolean isWaiting(User user, Book book) {
        for (IsWaiting waiting : waitingQueue) {
            if (waiting.getArg0().equals(user) && waiting.getArg1().equals(book))
                return true;
        }
        return false;
    }
}
