package lec11_collections.home.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dmya on 3/15/2016.
 */

public class User {
    final public String userName;
    public Set<Book> userBooks = new HashSet<Book>(); //Set is used coz the Book is unique

    public User(String userName) {
        this.userName = userName;
    }
}