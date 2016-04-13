package com.tsystems.library.libclient;

import com.tsystems.library.libservice.LibraryWS;
import com.tsystems.library.libservice.LibraryWSImplService;
import com.tsystems.library.libservice.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
        } else {
            LibraryWSImplService service = new LibraryWSImplService();
            client = service.getLibraryWSImplPort();
        }
        System.out.println(makeItYellow("TEST IS STARTED FOR MOCK = " + mock));
        System.out.println("-----------------------------------------------");
    }

    /**
     * Checks that we able to add a new User.
     * TODO method addUser must return UserID
     */
    @Test(enabled = true)
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
        System.out.println("Step5: Check new User was actually added.");

//        List<String> User = new ArrayList<>();
//        for (String userId : usersMap.keySet()) {
//            listID.add(userId);
//        }
//        return listID;
//        for ()
        User newUser = client.getUser(client.getUserIds().get(after - 1));
        assertNotNull(newUser);
        System.out.println(makeItGreen("User with Name = " + newUser.getName() + " and Surname = " + newUser.getSurname() + " was created."));
        System.out.println("Step6: Check entered Name and Surname.");
        assertEquals(newUser.getName(), NEW_NAME, "check Name");
        assertEquals(newUser.getSurname(), NEW_SURNAME, "check Surname");
    }

    /**
     * Checks we can get all the user IDs in the system.
     */
    @Test(enabled = true)
    public void testGetUserIds() {
        System.out.println("Step1: Get all UserIDs.");
        List<String> userIds = client.getUserIds();
        assertNotNull(userIds);
        System.out.println("Step2: Print all UserIDs.");
        System.out.println(makeItGreen("UserIDs: " + userIds));
    }

    /**
     * Checks we can get user details by it's ID.
     */
    @Test(enabled = true)
    public void testGetUser() {
        System.out.println("Step1: Add a new User.");
        boolean isCreated = client.addUser(NEW_NAME, NEW_SURNAME);
        assertTrue(isCreated);
        System.out.println("Step2: Get the new User by ID.");
        int size = client.getUserIds().size();
        System.out.println(size);
        User newUser = client.getUser(client.getUserIds().get(size - 1));
        assertNotNull(newUser);
        System.out.println(makeItGreen("User with Name = " + newUser.getName() + " and Surname = " + newUser.getSurname() + " was created."));
    }

    @Test(enabled = true)
    public void testAddBook() throws Exception {

    }

    @Test(enabled = true)
    public void testGetBooks() throws Exception {

    }

    @Test(enabled = true)
    public void testTakeBook() throws Exception {

    }

    @Test(enabled = true)
    public void testReturnBook() throws Exception {

    }

    @Test(enabled = true)
    public void testGetBook() throws Exception {

    }

    @Test(enabled = true)
    public void testAddAuthor() throws Exception {

    }

    @Test(enabled = true)
    public void testGetAuthors() throws Exception {

    }

    @Test(enabled = true)
    public void testIsWaiting() throws Exception {

    }

}