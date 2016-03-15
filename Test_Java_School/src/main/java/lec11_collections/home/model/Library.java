package lec11_collections.home.model;

import lec11_collections.home.execute.Main;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dmya on 3/15/2016.
 */
public class Library {
    public Set<Book> libraryBooks;
    public Map<String, Integer> bookQuantity;
    public Queue<BookRequest> usersRequest;

    public void takeBook(UserReader userReader, String bookName) {
        Book existedBook = Main.findBookByName(userReader.userBooks, bookName);
        if (existedBook != null) {
            System.out.println("Пользователь " + userReader.userName + " уже взял книгу " + bookName + ", сорян :(");
            return;
        }
        Book takenBook = Main.findBookByName(libraryBooks, bookName);
        int currentQty = bookQuantity.get(bookName);
        if (currentQty != 0) {
            bookQuantity.put(bookName, currentQty - 1);
        } else {
//            добавить в очередь
        }
        userReader.userBooks.add(takenBook);
    }
}
