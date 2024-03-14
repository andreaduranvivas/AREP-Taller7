package edu.arep.user;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String username;
    private String passwordHash;

    public User(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            this.passwordHash = bytesToHex(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            String inputHash = bytesToHex(encodedHash);
            return inputHash.equals(this.passwordHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }


    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public String getUsername() {
        return username;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        User usuario = new User("usuario_ejemplo");
        usuario.setPassword("contraseña_secreta");

        // Verificar la contraseña
        System.out.println(usuario.checkPassword("contraseña_secreta")); // Debería imprimir true
        System.out.println(usuario.checkPassword("contraseña_incorrecta")); // Debería imprimir false
    }


}
