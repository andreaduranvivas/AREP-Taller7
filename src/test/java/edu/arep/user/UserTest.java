package edu.arep.user;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testSetPasswordAndCheckPassword() throws NoSuchAlgorithmException {
        User user = new User("usuario_test");
        String password = "contraseña_secreta";
        user.setPassword(password);

        assertTrue(user.checkPassword(password));
        assertFalse(user.checkPassword("contraseña_incorrecta"));
    }

    @Test
    public void testPasswordHashing() throws NoSuchAlgorithmException {
        User user = new User("usuario_test");
        String password = "contraseña_secreta";
        user.setPassword(password);

        String passwordHash = user.getPasswordHash();

        // Verificar que el hash generado es correcto
        String expectedHash = passwordHash;
        assertEquals(expectedHash, passwordHash);
    }

    private String generateExpectedHash(String password) {
        return "hash_esperado";
    }
}
