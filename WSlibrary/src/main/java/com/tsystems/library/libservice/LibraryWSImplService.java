
package com.tsystems.library.libservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 */
@WebServiceClient(name = "LibraryWSImplService", targetNamespace = "http://libservice/", wsdlLocation = "http://10.233.57.103:8888/ws/library?wsdl")
public class LibraryWSImplService
        extends Service {

    private final static URL LIBRARYWSIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException LIBRARYWSIMPLSERVICE_EXCEPTION;
    private final static QName LIBRARYWSIMPLSERVICE_QNAME = new QName("http://libservice/", "LibraryWSImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://10.233.57.103:8888/ws/library?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LIBRARYWSIMPLSERVICE_WSDL_LOCATION = url;
        LIBRARYWSIMPLSERVICE_EXCEPTION = e;
    }

    public LibraryWSImplService() {
        super(__getWsdlLocation(), LIBRARYWSIMPLSERVICE_QNAME);
    }

    public LibraryWSImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), LIBRARYWSIMPLSERVICE_QNAME, features);
    }

    public LibraryWSImplService(URL wsdlLocation) {
        super(wsdlLocation, LIBRARYWSIMPLSERVICE_QNAME);
    }

    public LibraryWSImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LIBRARYWSIMPLSERVICE_QNAME, features);
    }

    public LibraryWSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LibraryWSImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns LibraryWS
     */
    @WebEndpoint(name = "LibraryWSImplPort")
    public LibraryWS getLibraryWSImplPort() {
        return super.getPort(new QName("http://libservice/", "LibraryWSImplPort"), LibraryWS.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns LibraryWS
     */
    @WebEndpoint(name = "LibraryWSImplPort")
    public LibraryWS getLibraryWSImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://libservice/", "LibraryWSImplPort"), LibraryWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LIBRARYWSIMPLSERVICE_EXCEPTION != null) {
            throw LIBRARYWSIMPLSERVICE_EXCEPTION;
        }
        return LIBRARYWSIMPLSERVICE_WSDL_LOCATION;
    }

}
