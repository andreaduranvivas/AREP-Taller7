package edu.arep.login;

import edu.arep.user.UserManager;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class Login {
    public static void main(String[] args) {
        staticFiles.location("/public");

        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("certificados/ecikeystore.p12", "123456", null, null);

        // Asegúrate de que el UserManager esté inicializado con usuarios
        UserManager userManager = new UserManager();
        UserManager.addUser("usuario1", "contraseña1");
        UserManager.addUser("usuario2", "contraseña2");

        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("certificados/ecikeystore.p12", "123456", null, null);

        port(getPort());

        post("/login", (req, res) -> {
            String username = req.queryParams("username");
            String password = req.queryParams("password");

            if (UserManager.userExists(username) && UserManager.getUser(username).checkPassword(password)) {
                return "Autenticación exitosa";
            } else {
                res.status(401); // Unauthorized
                return "Autenticación fallida";
            }
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}
