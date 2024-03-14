package edu.arep.user;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static Map<String, User> usuarios;

    public UserManager() {
        usuarios = new HashMap<>();
    }

    public static void addUser(String username, String password) {
        User user = new User(username);
        user.setPassword(password);
        usuarios.put(username, user);
    }

    public void deleteUser(String username) {
        usuarios.remove(username);
    }

    public static User getUser(String username) {
        return usuarios.get(username);
    }

    public static boolean userExists(String username) {
        return usuarios.containsKey(username);
    }

    public static void main(String[] args) {
        UserManager manager = new UserManager();
        manager.addUser("usuario1", "contraseña1");
        manager.addUser("usuario2", "contraseña2");

        System.out.println(manager.userExists("usuario1")); // Debería imprimir "true"
        System.out.println(manager.userExists("usuario3")); // Debería imprimir "false"

        manager.deleteUser("usuario1");
        System.out.println(manager.userExists("usuario1")); // Debería imprimir "false"
    }
}

