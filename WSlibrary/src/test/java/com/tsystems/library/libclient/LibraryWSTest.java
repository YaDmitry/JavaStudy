package com.tsystems.library.libclient;

import com.tsystems.library.libservice.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @BeforeMethod
    // Initialize ServiceWS or MockWS
    public static void init() {
        boolean mock = false;
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
        System.out.println(makeItGreen("RESULT: ") + "User with Name = " + newUser.getName() + " and Surname = " + newUser.getSurname() + " was created.");
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
        System.out.println(makeItGreen("RESULT: ") + randomId);
        System.out.println("Step3: Get user by random ID.");
        User user = client.getUser(randomId);
        assertNotNull(user, "User is NOT null");
        System.out.println(makeItGreen("RESULT: ") + "User with Name = " + user.getName() + " and Surname = " + user.getSurname() + " was found.");
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
        System.out.println(makeItGreen("RESULT: ") + rndmAuthor);
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
        System.out.println(makeItGreen("RESULT: ") + rndmAuthor);
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

    /**
     * Checks user can take a book from library.
     * Checks Amount of books decreases according to User actions
     * Checks user is NOT on Waiting list if the book is available in the library.
     */
    @Test
    public void testTakeBookNotWaiting() {
        System.out.println("Step1: Request Books for test BEFORE.");
        List<Author> authors = client.getAuthors();
        assertTrue(authors != null && !authors.isEmpty(), "Authors list is NOT null and NOT empty");
        List<Book> books1 = client.getBooks(authors.get(0));
        List<Book> books2 = client.getBooks(authors.get(2));
        List<Book> books3 = client.getBooks(authors.get(3));
        // Get the amount of available books before
        int amountBook10Before = client.getBook(books1.get(0)).getAmount();
        int amountBook11Before = client.getBook(books1.get(1)).getAmount();
        int amountBook30Before = client.getBook(books3.get(0)).getAmount();

        System.out.println(authors.get(0) + " " + books1);
        System.out.println(authors.get(2) + " " + books2);
        System.out.println(authors.get(3) + " " + books3);

        System.out.println("Step2: Request Users for test.");
        List<String> userIds = client.getUserIds();
        assertTrue(userIds != null && !userIds.isEmpty(), "UserIDs list is NOT null and NOT empty");
        User user1 = client.getUser(userIds.get(1));
        User user2 = client.getUser(userIds.get(2));
        User user3 = client.getUser(userIds.get(3));
        System.out.println(makeItYellow(user1 + "") + ", " + makeItYellow(user2 + "") + ", " + makeItYellow(user3 + ""));

        System.out.println("Step3: Take books from the library by Users.");
        client.takeBook(user1, books1.get(0));
        amountBook10Before--;
        printUserAction(user1 + "", books1.get(0).getTitle());
        client.takeBook(user2, books1.get(0));
        amountBook10Before--;
        printUserAction(user2 + "", books1.get(0).getTitle());
        client.takeBook(user3, books3.get(0));
        amountBook30Before--;
        printUserAction(user3 + "", books3.get(0).getTitle());
        client.takeBook(user1, books1.get(1));
        amountBook11Before--;
        printUserAction(user1 + "", books1.get(1).getTitle());
        client.takeBook(user3, books1.get(1));
        amountBook11Before--;
        printUserAction(user3 + "", books1.get(1).getTitle());

        System.out.println("Step4: Request Books for test AFTER.");
        // Get the amount of available books before
        int amountBook10After = client.getBook(books1.get(0)).getAmount();
        int amountBook11After = client.getBook(books1.get(1)).getAmount();
        int amountBook30After = client.getBook(books3.get(0)).getAmount();
        System.out.println(authors.get(0) + " " + books1);
        System.out.println(authors.get(2) + " " + books2);
        System.out.println(authors.get(3) + " " + books3);

        System.out.println("Step5: Check book Amount decreased according to User actions.");
        assertEquals(amountBook10After, amountBook10Before);
        assertEquals(amountBook11After, amountBook11Before);
        assertEquals(amountBook30After, amountBook30Before);
        System.out.println("Step6: Check NOBODY is waiting for the book.");
        assertFalse(client.isWaiting(user1, books1.get(0)));
        assertFalse(client.isWaiting(user1, books1.get(1)));
        assertFalse(client.isWaiting(user1, books3.get(0)));
        assertFalse(client.isWaiting(user2, books1.get(0)));
        assertFalse(client.isWaiting(user2, books1.get(1)));
        assertFalse(client.isWaiting(user2, books3.get(0)));
        assertFalse(client.isWaiting(user3, books1.get(0)));
        assertFalse(client.isWaiting(user3, books1.get(1)));
        assertFalse(client.isWaiting(user3, books3.get(0)));

        System.out.println(makeItGreen("RESULT: ") + "Amount was decreased accordingly and nobody is waiting for the book.");
    }

    /**
     * Checks user can take a book from library.
     * Checks user is ON Waiting list if the book is NOT available in the library.
     */
    @Test
    public void testTakeBookIsWaiting() {
        System.out.println("Step1: Request Books for test BEFORE.");
        List<Author> authors = client.getAuthors();
        assertTrue(authors != null && !authors.isEmpty(), "Authors list is NOT null and NOT empty");
        List<Book> books1 = client.getBooks(authors.get(0));
        List<Book> books2 = client.getBooks(authors.get(2));
        List<Book> books3 = client.getBooks(authors.get(3));
        System.out.println(authors.get(0) + " " + books1);
        System.out.println(authors.get(2) + " " + books2);
        System.out.println(authors.get(3) + " " + books3);

        System.out.println("Step2: Request Users for test.");
        List<String> userIds = client.getUserIds();
        assertTrue(userIds != null && !userIds.isEmpty(), "UserIDs list is NOT null and NOT empty");
        User user1 = client.getUser(userIds.get(1));
        User user2 = client.getUser(userIds.get(2));
        User user3 = client.getUser(userIds.get(3));
        System.out.println(makeItYellow(user1 + "") + ", " + makeItYellow(user2 + "") + ", " + makeItYellow(user3 + ""));

        System.out.println("Step3: Take books from the library by Users.");
        client.takeBook(user1, books2.get(0));
        printUserAction(user1 + "", books2.get(0).getTitle());
        client.takeBook(user2, books2.get(0));
        printUserAction(user2 + "", books2.get(0).getTitle());
        client.takeBook(user2, books2.get(0));
        printUserAction(user2 + "", books2.get(0).getTitle());
        client.takeBook(user1, books3.get(0));
        printUserAction(user1 + "", books3.get(0).getTitle());
        client.takeBook(user1, books3.get(0));
        printUserAction(user1 + "", books3.get(0).getTitle());
        client.takeBook(user3, books3.get(0));
        printUserAction(user3 + "", books3.get(0).getTitle());

        System.out.println("Step4: Request Books for test AFTER.");
        System.out.println(authors.get(0) + " " + books1);
        System.out.println(authors.get(2) + " " + books2);
        System.out.println(authors.get(3) + " " + books3);
        System.out.println("Step5: Check users is ON waiting list.");
        assertTrue(client.isWaiting(user2, books2.get(0)));
        assertTrue(client.isWaiting(user3, books3.get(0)));
        System.out.println("Step6: Check users is NOT waiting list.");
        assertFalse(client.isWaiting(user1, books2.get(0)));
        assertFalse(client.isWaiting(user3, books2.get(0)));
        assertFalse(client.isWaiting(user1, books3.get(0)));
        assertFalse(client.isWaiting(user2, books3.get(0)));
        System.out.println(makeItGreen("RESULT: ") + "Waiting list on the book was filled correctly.");
    }

    /**
     * Checks user can return a book to a library.
     * Checks Amount of books increases according to User actions
     * Checks user is NOT on Waiting list if the book is available in the library.
     */
    @Test
    public void testReturnBook() {
        System.out.println("Step1: Request Books for test BEFORE.");
        List<Author> authors = client.getAuthors();
        assertTrue(authors != null && !authors.isEmpty(), "Authors list is NOT null and NOT empty");
        List<Book> books1 = client.getBooks(authors.get(0));
        List<Book> books2 = client.getBooks(authors.get(2));
        List<Book> books3 = client.getBooks(authors.get(3));
        // Get the amount of available books before
        int amountBook10Before = client.getBook(books1.get(0)).getAmount();
        int amountBook11Before = client.getBook(books1.get(1)).getAmount();
        int amountBook30Before = client.getBook(books3.get(0)).getAmount();

        System.out.println(authors.get(0) + " " + books1);
        System.out.println(authors.get(2) + " " + books2);
        System.out.println(authors.get(3) + " " + books3);

        System.out.println("Step2: Request Users for test.");
        List<String> userIds = client.getUserIds();
        assertTrue(userIds != null && !userIds.isEmpty(), "UserIDs list is NOT null and NOT empty");
        User user1 = client.getUser(userIds.get(1));
        User user2 = client.getUser(userIds.get(2));
        User user3 = client.getUser(userIds.get(3));
        System.out.println(makeItYellow(user1 + "") + ", " + makeItYellow(user2 + "") + ", " + makeItYellow(user3 + ""));

        System.out.println("Step3: Return books to the library by Users.");
        client.returnBook(user1, books1.get(0));
        amountBook10Before++;
        printUserAction(user1 + "", books1.get(0).getTitle());
        client.returnBook(user2, books1.get(0));
        amountBook10Before++;
        printUserAction(user2 + "", books1.get(0).getTitle());
        client.returnBook(user3, books3.get(0));
        amountBook30Before++;
        printUserAction(user3 + "", books3.get(0).getTitle());
        client.returnBook(user1, books1.get(1));
        amountBook11Before++;
        printUserAction(user1 + "", books1.get(1).getTitle());
        client.returnBook(user3, books1.get(1));
        amountBook11Before++;
        printUserAction(user3 + "", books1.get(1).getTitle());

        System.out.println("Step4: Request Books for test AFTER.");
        // Get the amount of available books before
        int amountBook10After = client.getBook(books1.get(0)).getAmount();
        int amountBook11After = client.getBook(books1.get(1)).getAmount();
        int amountBook30After = client.getBook(books3.get(0)).getAmount();
        System.out.println(authors.get(0) + " " + books1);
        System.out.println(authors.get(2) + " " + books2);
        System.out.println(authors.get(3) + " " + books3);

        System.out.println("Step5: Check book Amount decreased according to User actions.");
        assertEquals(amountBook10After, amountBook10Before);
        assertEquals(amountBook11After, amountBook11Before);
        assertEquals(amountBook30After, amountBook30Before);
        System.out.println("Step6: Check NOBODY is waiting for the book.");
        assertFalse(client.isWaiting(user1, books1.get(0)));
        assertFalse(client.isWaiting(user1, books1.get(1)));
        assertFalse(client.isWaiting(user1, books3.get(0)));
        assertFalse(client.isWaiting(user2, books1.get(0)));
        assertFalse(client.isWaiting(user2, books1.get(1)));
        assertFalse(client.isWaiting(user2, books3.get(0)));
        assertFalse(client.isWaiting(user3, books1.get(0)));
        assertFalse(client.isWaiting(user3, books1.get(1)));
        assertFalse(client.isWaiting(user3, books3.get(0)));

        System.out.println(makeItGreen("RESULT: ") + "Amount was increased accordingly and nobody is waiting for the book.");
    }
}