package com.tsystems.library.libclient;

import com.tsystems.library.libclient.test.LibraryWSMock;
import com.tsystems.library.libservice.LibraryWS;

import java.net.MalformedURLException;

public class LibraryWSPublisher {
    public static void main(String... strings) throws MalformedURLException {

        LibraryWS ws = new LibraryWSMock();
        LibraryWSClient client = new LibraryWSClient(ws);
        client.addUser("1", "2");
    }

}
