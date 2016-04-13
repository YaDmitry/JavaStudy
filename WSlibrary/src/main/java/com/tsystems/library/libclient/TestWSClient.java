package com.tsystems.library.libclient;

import com.tsystems.library.libservice.*;

import javax.xml.ws.WebServiceRef;
import java.util.List;

/**
 * Created by dyaprint on 07.04.2016.
 */
public class TestWSClient {

//    @WebServiceRef(wsdlLocation = "http://10.233.57.103:8888/ws/library?wsdl")
    static LibraryWSImplService service = new LibraryWSImplService();

    public static void main(String[] args) {
        boolean mock = true;
        LibraryWS port;
        if (mock) {
            port = new LibraryWSMock();
        } else {
            port = service.getLibraryWSImplPort();
        }

//        LibraryWS libraryWSImplPort = service.getLibraryWSImplPort();

        // Add User|ctrl + alt + V
        boolean isUserAdd1 = port.addUser("Name1", "Surname1");
        boolean isUserAdd2 = port.addUser("Name2", "Surname2");
        boolean isUserAdd3 = port.addUser("Name3", "Surname3");
        boolean isUserAdd4 = port.addUser("Name4", "Surname5");
//        System.out.println(isUserAdd1);

        // Get UserIds
        List<String> userIds = port.getUserIds();
        System.out.println(userIds);

        // Get User
        User user = port.getUser(userIds.get(2));
        System.out.println(user);

        // Get Authors
        List<Author> authors = port.getAuthors();
        System.out.println("Authotrs: " + authors);

        //Get Books
        List<Book> books = port.getBooks(authors.get(0));
        System.out.println(books);

        // Get Book
        Book book = port.getBook(books.get(0));
        System.out.println(book);

        // Take Book
        port.takeBook(user, book);
//
        // Return Book
        port.returnBook(user, book);

        // Is Waiting
        boolean isWaiting = port.isWaiting(user, book);
        System.out.println(isWaiting);

    }
}