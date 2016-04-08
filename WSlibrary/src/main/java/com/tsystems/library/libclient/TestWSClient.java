package com.tsystems.library.libclient;

import com.tsystems.library.libclient.test.LibraryWSMock;
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
//        List<Author> authors = port.getAuthors(); //ctrl+alt+V
//        boolean sdfsf = port.addUser("23", "sdfsf");
//        System.out.println(authors);
        User user = port.getUser("d70c7f56-b238-4f42-bcbd-a0155ac6f6fd");
        System.out.println("User = " + user);
    }
}