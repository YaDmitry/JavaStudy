package lec11_collections.home.model;

import java.util.*;

import static lec11_collections.home.model.Logging.*;

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
            System.out.println("Читатель " + makeItGreen(user.userName) + " уже взял(а) книгу " + makeItYellow(bookName) + ", он(а) не может взять ее повторно.");
            return;
        }

        //check if requested book exists in the Library
        Book requestedBook = findBookByName(libraryBooks, bookName);
        if (requestedBook == null) {
            System.out.println("Читатель " + makeItGreen(user.userName) + " попросил(а) книгу " + makeItYellow(bookName) + ": " + makeItRed("КНИГА НЕ НАЙДЕНА!") + " У нас только художественная литература.");
            return;
        }

        //check aviability of requested book:
        //if YES -> add book into users collection of Books
        //if NO -> add user and requested book into waiting list, which is Queue<BookRequest>
        int currentQty = bookQty.get(bookName);
        if (currentQty != 0) {
            bookQty.put(bookName, currentQty - 1);
            user.userBooks.add(requestedBook);
            System.out.println("Читатель " + makeItGreen(user.userName) + " взял(а) книгу " + makeItYellow(bookName) + ".");
        } else {
            usersQueue.add(new BookRequest(user, requestedBook));
            System.out.println("Читатель " + makeItGreen(user.userName) + " добавлен(а) в очередь на книгу " + makeItYellow(requestedBook.bookName) + ".");
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

    //Print all available books in the Library
    public void printAllBooks() {
        //Move collection SetBooks into ArrayList. It's possible now to sort Books by Author name
        List<Book> sortedListOfBooks = new ArrayList<Book>(libraryBooks);
        Collections.sort(sortedListOfBooks, new BookComparator());
        for (Book book : sortedListOfBooks)
            System.out.println(makeItYellow(book.bookAuthor + ": " + book.bookName) + ", доступно: " + bookQty.get(book.bookName));
    }

    //Print all Users in Queue
    public void printQueueUsers() {
        for (BookRequest queue : usersQueue)
            System.out.println(makeItGreen(queue.user.userName) + " ожидает книгу " + makeItYellow(queue.book.bookName) + ".");
    }
}


//    Iterator<Book> iterator = sortedListOfBooks.iterator();
//        while (iterator.hasNext()){
//                Book book=iterator.next();
// }