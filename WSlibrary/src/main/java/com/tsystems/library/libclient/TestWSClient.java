package com.tsystems.library.libclient;

import com.tsystems.library.libclient.test.LibraryWSMock;
import com.tsystems.library.libservice.Author;
import com.tsystems.library.libservice.LibraryWS;
import com.tsystems.library.libservice.LibraryWSImplService;

import javax.xml.ws.WebServiceRef;
import java.util.List;

/**
 * Created by dyaprint on 07.04.2016.
 */
public class TestWSClient {

    @WebServiceRef(wsdlLocation = "http://10.233.57.103:8888/ws/library?wsdl")
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
        List<Author> authors = port.getAuthors(); //ctrl+alt+V
        boolean sdfsf = port.addUser("23", "sdfsf");
        System.out.println(authors);
    }
}