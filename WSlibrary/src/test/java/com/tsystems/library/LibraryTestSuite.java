package com.tsystems.library;

import com.tsystems.library.libclient.LibraryWSMock;
import com.tsystems.library.libservice.Author;
import com.tsystems.library.libservice.LibraryWS;
import com.tsystems.library.libservice.LibraryWSImplService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by dyaprint on 07.04.2016.
 */
public class LibraryTestSuite {

    static LibraryWS client;

    @BeforeClass
    public static void init() {
        boolean mock = true;
        LibraryWSImplService service = new LibraryWSImplService();
        if (mock) {
            client = new LibraryWSMock();
        } else {
            client = service.getLibraryWSImplPort();
        }
    }

    @Test
    public void testGetAuthors() {
        // test thatt authors list is not empty
        List<Author> authors = client.getAuthors();
        System.out.println(authors);
        assertTrue("authors list is null or empty", authors != null && !authors.isEmpty());
    }

}
