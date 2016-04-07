package com.tsystems.library.libclient.test;

import com.tsystems.library.libservice.Author;
import com.tsystems.library.libservice.Book;
import com.tsystems.library.libservice.LibraryWS;
import com.tsystems.library.libservice.User;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dyaprint on 07.04.2016.
 */
public class LibraryWSMock implements LibraryWS {

    Map<String, User> usersById = new HashMap<>();
//    List<User> users = new ArrayList<>();

    public LibraryWSMock() {
        User u1 = new User();
        usersById.put("awelfhawef",u1);
    }

    @Override
    public List<String> getUserIds() {
        return null;
    }

    @Override
    public User getUser(String id) {
        return usersById.get(id);
    }

    @Override
    public boolean addUser(@WebParam(name = "arg0", targetNamespace = "") String arg0, @WebParam(name = "arg1", targetNamespace = "") String arg1) {
        User user = new User();
        user.setName(arg0);
        user.setSurname(arg1);
        // generate id
        String id = Math.ceil(Math.random()*100) + "-" + Math.ceil(Math.random()*100);
        usersById.put(id, user);
        return true;
    }

    @Override
    public List<Book> getBooks(@WebParam(name = "arg0", targetNamespace = "") Author arg0) {
        return null;
    }

    @Override
    public void takeBook(@WebParam(name = "arg0", targetNamespace = "") User arg0, @WebParam(name = "arg1", targetNamespace = "") Book arg1) {

    }

    @Override
    public void returnBook(@WebParam(name = "arg0", targetNamespace = "") User arg0, @WebParam(name = "arg1", targetNamespace = "") Book arg1) {

    }

    @Override
    public Book getBook(@WebParam(name = "arg0", targetNamespace = "") Book arg0) {
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
    public boolean isWaiting(@WebParam(name = "arg0", targetNamespace = "") User arg0, @WebParam(name = "arg1", targetNamespace = "") Book arg1) {
        return false;
    }
}
