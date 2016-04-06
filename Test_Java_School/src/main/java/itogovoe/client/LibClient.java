package itogovoe.client;

import itogovoe.libservice.Author;
import itogovoe.libservice.LibraryWS;
import itogovoe.libservice.LibraryWSImplService;

import javax.xml.ws.WebServiceRef;
import java.util.List;

/**
 * Created by dyaprint on 05.04.2016.
 */
public class LibClient {

    @WebServiceRef(wsdlLocation = "http://10.233.57.103:8888/ws/library?wsdl")
    static LibraryWSImplService service = new LibraryWSImplService();

    public static void main(String[] args) {
        LibraryWS libraryWSImplPort = service.getLibraryWSImplPort();
        List<Author> authors = libraryWSImplPort.getAuthors(); //ctrl+alt+V
        System.out.println(authors);
    }
}
