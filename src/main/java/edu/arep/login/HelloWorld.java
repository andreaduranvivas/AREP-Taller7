package edu.arep.login;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class HelloWorld {
    public static void main(String[] args) {

        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("certificados/ecikeystore.p12", "123456", null, null);

        port(getPort());

        post("/login", (req, res) ->
                "Hello World"
        );
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}
