package com.tsystems.library.libclient;

import com.tsystems.library.libservice.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.tsystems.library.libclient.CommonConstants.NEW_NAME;
import static com.tsystems.library.libclient.CommonConstants.NEW_SURNAME;

import static com.tsystems.library.libclient.Logging.*;
import static org.testng.Assert.*;

/**
 * Created by dyaprint on 13.04.2016.
 */
public class LibraryWSTest {

    static LibraryWS client;

    @BeforeClass
    // Initialize ServiceWS or MockWS
    public static void init() {
        boolean mock = true;
        if (mock == true) {
            client = new LibraryWSMock();
            System.out.println(makeItYellow("TEST IS STARTED FOR MOCK"));
            System.out.println("===============================================");
        } else {
            LibraryWSImplService service = new LibraryWSImplService();
            client = service.getLibraryWSImplPort();
            System.out.println(makeItYellow("TEST IS STARTED FOR SERVICE"));
            System.out.println("===============================================");
        }
    }

    /**
     * Checks that we able to add a new User.
     * TODO method addUser must return UserID
     * TODO make userID generation sortable
     */
    @Test
    public void testAddUser() {
        System.out.println("Step1: Get all UserIDs BEFORE.");
        int before = client.getUserIds().size();
        System.out.println("Step2: Add a new User.");
        boolean isCreated = client.addUser(NEW_NAME, NEW_SURNAME);
        assertTrue(isCreated);
        System.out.println("Step3: Get all UserIDs AFTER.");
        int after = client.getUserIds().size();
        System.out.println("Step4: Check UserIDs increased by one.");
        assertEquals(before + 1, after);
        System.out.println("Step5: Check entered Name and Surname.");
        User newUser = client.getUser(client.getUserIds().get(after - 1));
        assertNotNull(newUser, "User is NOT null");
        assertEquals(newUser.getName(), NEW_NAME, "check Name");
        assertEquals(newUser.getSurname(), NEW_SURNAME, "check Surname");
        System.out.println("Step6: Check new User was actually added.");
        System.out.println(makeItGreen("RESULT: ") +"User with Name = " + newUser.getName() + " and Surname = " + newUser.getSurname() + " was created.");
    }

    /**
     * Checks we can get all the user IDs.
     */
    @Test
    public void testGetUserIds() {
        System.out.println("Step1: Get all UserIDs.");
        List<String> userIds = client.getUserIds();
        assertTrue(userIds != null && !userIds.isEmpty(), "UserIDs list is NOT null and NOT empty");
        System.out.println("Step2: Print all UserIDs.");
        System.out.println(makeItGreen("RESULT: ") + userIds);
    }

    /**
     * Checks we can get user details by it's ID.
     */
    @Test
    public void testGetUser() {
        System.out.println("Step1: Get a list of all User IDs.");
        List<String> userIds = client.getUserIds();
        assertTrue(userIds != null && !userIds.isEmpty(), "UserIDs list is NOT null and NOT empty");
        System.out.println("Step2: Get random ID.");
        Random randomizer = new Random();
        String randomId = userIds.get(randomizer.nextInt(userIds.size()));
        System.out.println(makeItGreen("RESULT: ")+randomId);
        System.out.println("Step3: Get user by random ID.");
        User user = client.getUser(randomId);
        assertNotNull(user, "User is NOT null");
        System.out.println(makeItGreen("RESULT: ") +"User with Name = " + user.getName() + " and Surname = " + user.getSurname() + " was found.");
    }

    /**
     * Checks we can get all the Authors from the system.
     */
    @Test
    public void testGetAuthors() {
        System.out.println("Step1: Get all Authors.");
        List<Author> authors = client.getAuthors();
        assertTrue(authors != null && !authors.isEmpty(), "Authors list is NOT null and NOT empty");
        System.out.println("Step2: Print all Authors.");
        System.out.println(makeItGreen("RESULT: ") + authors);
    }

    /**
     * Checks we can get a list of books by the Author.
     */
    @Test
    public void testGetBooks() {
        System.out.println("Step1: Get a list of Authors.");
        List<Author> authors = client.getAuthors();
        assertTrue(authors != null && !authors.isEmpty(), "Authors list is NOT null and NOT empty");
        System.out.println("Step2: Get a random Author from list.");
        Random randomizer = new Random();
        Author rndmAuthor = authors.get(randomizer.nextInt(authors.size()));
        System.out.println(makeItGreen("RESULT: ")+rndmAuthor);
        System.out.println("Step3: Get a list of books by the Author.");
        List<Book> books = client.getBooks(rndmAuthor);
        assertTrue(books != null && !books.isEmpty(), "Books list is NOT null and NOT empty");
        System.out.println(makeItGreen("RESULT: ") + books);
    }

    /**
     * Checks we can get a book by the book.
     */
    @Test
    public void testGetBook() {
        System.out.println("Step1: Get a list of Authors.");
        List<Author> authors = client.getAuthors();
        assertTrue(authors != null && !authors.isEmpty(), "Authors list is NOT null and NOT empty");
        System.out.println("Step2: Get a random Author from list.");
        Random randomizer = new Random();
        Author rndmAuthor = authors.get(randomizer.nextInt(authors.size()));
        System.out.println(makeItGreen("RESULT: ")+rndmAuthor);
        System.out.println("Step3: Get a list of books by the Author.");
        List<Book> books = client.getBooks(rndmAuthor);
        assertTrue(books != null && !books.isEmpty(), "Books list is NOT null and NOT empty");
        System.out.println(makeItGreen("RESULT: ") + books);
        System.out.println("Step4: Get a random Book from list.");
        Book rndmBook = books.get(randomizer.nextInt(books.size()));
        assertNotNull(rndmBook, "Book is NOT null");
        Book book = client.getBook(rndmBook);
        assertNotNull(book, "Book is NOT null");
        System.out.println(makeItGreen("RESULT: ") + book);
    }

    @Test
    public void testTakeBook() {

        

    }

    @Test(enabled = true)
    public void testTakeBookIsWaiting() {



    }

    @Test(enabled = true)
    public void testReturnBook() throws Exception {

    }

    @Test(enabled = true)
    public void testIsWaiting() throws Exception {

    }

}