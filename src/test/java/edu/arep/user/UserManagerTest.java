package edu.arep.user;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserManagerTest {

    private UserManager userManager;

    @Before
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testAddUser() {
        userManager.addUser("usuario1", "contraseña1");
        assertTrue(userManager.userExists("usuario1"));
    }

    @Test
    public void testDeleteUser() {
        userManager.addUser("usuario1", "contraseña1");
        userManager.deleteUser("usuario1");
        assertFalse(userManager.userExists("usuario1"));
    }

    @Test
    public void testGetUser() {
        userManager.addUser("usuario1", "contraseña1");
        User user = userManager.getUser("usuario1");
        assertNotNull(user);
        assertEquals("usuario1", user.getUsername());
    }

    @Test
    public void testUserExists() {
        userManager.addUser("usuario1", "contraseña1");
        assertTrue(userManager.userExists("usuario1"));
        assertFalse(userManager.userExists("usuario2"));
    }
}
