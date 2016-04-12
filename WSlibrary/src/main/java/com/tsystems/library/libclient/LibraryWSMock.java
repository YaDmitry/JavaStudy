package com.tsystems.library.libclient;

import com.tsystems.library.libservice.*;

import java.util.*;

/**
 * Created by dyaprint on 07.04.2016.
 */
public class LibraryWSMock implements LibraryWS {

    Map<String, User> usersById = new HashMap<>();
    List<Book> books = new ArrayList<>();
    Queue<IsWaiting> waitingQueue = new ArrayDeque<IsWaiting>();



//  List<User> users = new ArrayList<>();

    public LibraryWSMock() {
    }

    @Override
    public List<String> getUserIds() {
        Set<String> set = usersById.keySet();
        ArrayList<String> result = new ArrayList<>();
        result.addAll(set);
        return result;
    }

    @Override
    public User getUser(String id) {
        return usersById.get(id);
    }

    @Override
    public boolean addUser(String arg0, String arg1) {
        User user = new User();
        user.setName(arg0);
        user.setSurname(arg1);
        // generate id
        String id = Math.ceil(Math.random() * 100) + "-" + Math.ceil(Math.random() * 100);
        usersById.put(id, user);
        return true;
    }

    @Override
    public List<Book> getBooks(Author author) {
        List<Book> result = null;
        for (Book book : books) {
            Author bookAuthor = book.getAuthor();
            if (bookAuthor.getName().equals(author.getName())
                    && bookAuthor.getSurname().equals(author.getSurname())) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(book);
            }
        }
        return result;
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
    public void returnBook(User arg0, Book returnedBook) {
        for (Book book : books) {
            if (book.equals(returnedBook))
            {
                book.setAmount(book.getAmount() + 1);
            }
        }
    }

    @Override
    public Book getBook(Book gettedBook) {
        for (Book book : books) {
            if (book.equals(gettedBook))
                return book;
        }
        return null;
    }

    @Override
    public List<Author> getAuthors() {
        List<Author> result = new ArrayList<>();
        Author a = new Author();
        a.setName("dima");
        a.setSurname("ya");
        result.add(a);
        return result;
    }

    @Override
    public boolean isWaiting(User arg0, Book arg1) {
        for (IsWaiting waiting : waitingQueue) {
            if (waiting.getArg0().equals(arg0) && waiting.getArg1().equals(arg1))
                return true;
        }
        return false;
    }
}
