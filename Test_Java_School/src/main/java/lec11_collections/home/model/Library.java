package lec11_collections.home.model;

import java.util.*;

/**
 * Created by dmya on 3/15/2016.
 */
public class Library {

    public Set<Book> libraryBooks = new HashSet<Book>(); //Set is used coz the Book is unique
    public Map<String, Integer> bookQty = new HashMap<String, Integer>();
    public Queue<BookRequest> usersQueue = new ArrayDeque<BookRequest>();

    //User takes the requested Book and put it into his Collection of Books
    public void takeBook(User user, String bookName) {

        //check if user already has requested book
        Book existedBook = findBookByName(user.userBooks, bookName);
        if (existedBook != null) {
            System.out.println("Пользователь " + user.userName + " уже взял книгу " + bookName + ", он не может взять ее повторно.");
            return;
        }

        //check if requested book exists in the Library
        Book requestedBook = findBookByName(libraryBooks, bookName);
        if (requestedBook == null) {
            System.out.println("Пользователь " + user.userName + " попросил книгу " + bookName + ": КНИГА НЕ НАЙДЕНА! У нас только художественная литература.");
            return;
        }

        //check aviability of requested book:
        //if YES -> add book into users collection of Books
        //if NO -> add user and requested book into waiting list, which is Queue<BookRequest>
        int currentQty = bookQty.get(bookName);
        if (currentQty != 0) {
            bookQty.put(bookName, currentQty - 1);
            user.userBooks.add(requestedBook);
            System.out.println("Пользователь " + user.userName + " взял почитать книгу " + bookName + ".");
        } else {
            usersQueue.add(new BookRequest(user, requestedBook));
            System.out.println("Пользователь " + user.userName + " добавлен в очередь на книгу " + requestedBook.bookName + ".");
        }
    }

    //Find requested book in the Library, returns Book
    Book findBookByName(Set<Book> books, String bookName) {
        for (Book book : books) {
            if (bookName.equals(book.bookName))
                return book;
        }
        return null;
    }

    //Print all the available books in the Library
    public void printAllBooks() {
        //Move collection SetBooks into ArrayList. It's possible now to sort Books by Author name
        List<Book> sortedListOfBooks = new ArrayList<Book>(libraryBooks);
        Collections.sort(sortedListOfBooks, new BookComparator());
        for (Book book : sortedListOfBooks)
            System.out.println(book.bookAuthor + ": " + book.bookName + ", доступно: " + bookQty.get(book.bookName));
    }
}


//    Iterator<Book> iterator = sortedListOfBooks.iterator();
//        while (iterator.hasNext()){
//                Book book=iterator.next();
//                }