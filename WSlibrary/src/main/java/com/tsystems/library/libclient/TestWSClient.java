package com.tsystems.library.libclient;

import com.tsystems.library.libservice.*;

import javax.xml.ws.WebServiceRef;
import java.util.List;

/**
 * Created by dyaprint on 07.04.2016.
 */
public class TestWSClient {

    @WebServiceRef(wsdlLocation = "http://10.233.57.103:8888/ws/library?wsdl")
    static LibraryWSImplService service = new LibraryWSImplService();

    public static void main(String[] args) {
        boolean mock = false;
        LibraryWS port;
        if (mock) {
            port = new LibraryWSMock();
        } else {
            port = service.getLibraryWSImplPort();
        }
//        LibraryWS libraryWSImplPort = service.getLibraryWSImplPort();

//      Add User | ctrl+alt+V
        boolean isUserAdd = port.addUser("23", "sdfsf");
        System.out.println(isUserAdd);

//      Get Authors
        List<Author> authors = port.getAuthors();
        System.out.println(authors);

////      Get Book
//        Book book = port.getBook();
//
////      Get Books
//        List<Book> books = port.getBooks();

//      Get User
        User user = port.getUser("d70c7f56-b238-4f42-bcbd-a0155ac6f6fd");
        System.out.println(user);

//      Get UserIds
        List<String> userIds = port.getUserIds();
        System.out.println(userIds);
//
////      Is Waiting
//        boolean isWaiting = port.isWaiting();
//
////      Return Book
//        port.returnBook();
//
////      Take Book
//        port.takeBook();

    }
}