
package com.tsystems.library.libservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the libservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TakeBook_QNAME = new QName("http://libservice/", "takeBook");
    private final static QName _GetUserIdsResponse_QNAME = new QName("http://libservice/", "getUserIdsResponse");
    private final static QName _AddUserResponse_QNAME = new QName("http://libservice/", "addUserResponse");
    private final static QName _GetBookResponse_QNAME = new QName("http://libservice/", "getBookResponse");
    private final static QName _GetAuthors_QNAME = new QName("http://libservice/", "getAuthors");
    private final static QName _GetAuthorsResponse_QNAME = new QName("http://libservice/", "getAuthorsResponse");
    private final static QName _GetUser_QNAME = new QName("http://libservice/", "getUser");
    private final static QName _ReturnBook_QNAME = new QName("http://libservice/", "returnBook");
    private final static QName _GetBooks_QNAME = new QName("http://libservice/", "getBooks");
    private final static QName _IsWaiting_QNAME = new QName("http://libservice/", "isWaiting");
    private final static QName _GetUserIds_QNAME = new QName("http://libservice/", "getUserIds");
    private final static QName _ReturnBookResponse_QNAME = new QName("http://libservice/", "returnBookResponse");
    private final static QName _AddUser_QNAME = new QName("http://libservice/", "addUser");
    private final static QName _GetBooksResponse_QNAME = new QName("http://libservice/", "getBooksResponse");
    private final static QName _GetBook_QNAME = new QName("http://libservice/", "getBook");
    private final static QName _GetUserResponse_QNAME = new QName("http://libservice/", "getUserResponse");
    private final static QName _IsWaitingResponse_QNAME = new QName("http://libservice/", "isWaitingResponse");
    private final static QName _TakeBookResponse_QNAME = new QName("http://libservice/", "takeBookResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: libservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAuthors }
     * 
     */
    public GetAuthors createGetAuthors() {
        return new GetAuthors();
    }

    /**
     * Create an instance of {@link GetAuthorsResponse }
     * 
     */
    public GetAuthorsResponse createGetAuthorsResponse() {
        return new GetAuthorsResponse();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link TakeBook }
     * 
     */
    public TakeBook createTakeBook() {
        return new TakeBook();
    }

    /**
     * Create an instance of {@link GetUserIdsResponse }
     * 
     */
    public GetUserIdsResponse createGetUserIdsResponse() {
        return new GetUserIdsResponse();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link GetBookResponse }
     * 
     */
    public GetBookResponse createGetBookResponse() {
        return new GetBookResponse();
    }

    /**
     * Create an instance of {@link GetUserIds }
     * 
     */
    public GetUserIds createGetUserIds() {
        return new GetUserIds();
    }

    /**
     * Create an instance of {@link ReturnBookResponse }
     * 
     */
    public ReturnBookResponse createReturnBookResponse() {
        return new ReturnBookResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link GetBooksResponse }
     * 
     */
    public GetBooksResponse createGetBooksResponse() {
        return new GetBooksResponse();
    }

    /**
     * Create an instance of {@link ReturnBook }
     * 
     */
    public ReturnBook createReturnBook() {
        return new ReturnBook();
    }

    /**
     * Create an instance of {@link IsWaiting }
     * 
     */
    public IsWaiting createIsWaiting() {
        return new IsWaiting();
    }

    /**
     * Create an instance of {@link GetBooks }
     * 
     */
    public GetBooks createGetBooks() {
        return new GetBooks();
    }

    /**
     * Create an instance of {@link GetBook }
     * 
     */
    public GetBook createGetBook() {
        return new GetBook();
    }

    /**
     * Create an instance of {@link TakeBookResponse }
     * 
     */
    public TakeBookResponse createTakeBookResponse() {
        return new TakeBookResponse();
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link IsWaitingResponse }
     * 
     */
    public IsWaitingResponse createIsWaitingResponse() {
        return new IsWaitingResponse();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TakeBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "takeBook")
    public JAXBElement<TakeBook> createTakeBook(TakeBook value) {
        return new JAXBElement<TakeBook>(_TakeBook_QNAME, TakeBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserIdsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "getUserIdsResponse")
    public JAXBElement<GetUserIdsResponse> createGetUserIdsResponse(GetUserIdsResponse value) {
        return new JAXBElement<GetUserIdsResponse>(_GetUserIdsResponse_QNAME, GetUserIdsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "getBookResponse")
    public JAXBElement<GetBookResponse> createGetBookResponse(GetBookResponse value) {
        return new JAXBElement<GetBookResponse>(_GetBookResponse_QNAME, GetBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthors }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "getAuthors")
    public JAXBElement<GetAuthors> createGetAuthors(GetAuthors value) {
        return new JAXBElement<GetAuthors>(_GetAuthors_QNAME, GetAuthors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthorsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "getAuthorsResponse")
    public JAXBElement<GetAuthorsResponse> createGetAuthorsResponse(GetAuthorsResponse value) {
        return new JAXBElement<GetAuthorsResponse>(_GetAuthorsResponse_QNAME, GetAuthorsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "returnBook")
    public JAXBElement<ReturnBook> createReturnBook(ReturnBook value) {
        return new JAXBElement<ReturnBook>(_ReturnBook_QNAME, ReturnBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "getBooks")
    public JAXBElement<GetBooks> createGetBooks(GetBooks value) {
        return new JAXBElement<GetBooks>(_GetBooks_QNAME, GetBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsWaiting }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "isWaiting")
    public JAXBElement<IsWaiting> createIsWaiting(IsWaiting value) {
        return new JAXBElement<IsWaiting>(_IsWaiting_QNAME, IsWaiting.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserIds }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "getUserIds")
    public JAXBElement<GetUserIds> createGetUserIds(GetUserIds value) {
        return new JAXBElement<GetUserIds>(_GetUserIds_QNAME, GetUserIds.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "returnBookResponse")
    public JAXBElement<ReturnBookResponse> createReturnBookResponse(ReturnBookResponse value) {
        return new JAXBElement<ReturnBookResponse>(_ReturnBookResponse_QNAME, ReturnBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "getBooksResponse")
    public JAXBElement<GetBooksResponse> createGetBooksResponse(GetBooksResponse value) {
        return new JAXBElement<GetBooksResponse>(_GetBooksResponse_QNAME, GetBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "getBook")
    public JAXBElement<GetBook> createGetBook(GetBook value) {
        return new JAXBElement<GetBook>(_GetBook_QNAME, GetBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsWaitingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "isWaitingResponse")
    public JAXBElement<IsWaitingResponse> createIsWaitingResponse(IsWaitingResponse value) {
        return new JAXBElement<IsWaitingResponse>(_IsWaitingResponse_QNAME, IsWaitingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TakeBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://libservice/", name = "takeBookResponse")
    public JAXBElement<TakeBookResponse> createTakeBookResponse(TakeBookResponse value) {
        return new JAXBElement<TakeBookResponse>(_TakeBookResponse_QNAME, TakeBookResponse.class, null, value);
    }

}
