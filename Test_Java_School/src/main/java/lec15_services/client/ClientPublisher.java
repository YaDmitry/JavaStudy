package lec15_services.client;

import java.net.MalformedURLException;
import java.net.URL;

import lec15_services.webservice.SayWebService;
import lec15_services.webservice.SayWebServiceService;


/**
 * Created by dmya on 3/21/2016.
 */
public class ClientPublisher {
    public static void main(String[] args) throws MalformedURLException{

        URL url = new URL("http://10.233.57.103:8888/ws/server?wsdl");
        SayWebServiceService service = new SayWebServiceService(url);
        SayWebService port = service.getSayWebServicePort();
        System.out.println(port.say("blabla"));
    }
}
