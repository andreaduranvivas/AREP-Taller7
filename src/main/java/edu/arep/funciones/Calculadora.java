package edu.arep.funciones;

import static spark.Spark.*;

public class Calculadora {

    public static void main(String[] args){
        port(getPort());
        staticFiles.location("/public");

        secure("certificados/ecikeystore.p12", "123456", null, null);

        get("/calculadora", (req, res) -> {
            res.redirect("/calculadora.html");
            return null;
        });

        // Ruta para calcular el seno
        get("/sin", (req, res) -> {
            String angleParam = req.queryParams("angle");
            if (angleParam != null) {
                double angle = Double.parseDouble(angleParam);
                Calculator sinCalc = new Sin();
                return "Sin: " + sinCalc.calculate(new double[]{angle});
            } else {
                return "Parámetro 'angle' no proporcionado.";
            }
        });


        // Ruta para calcular el coseno usando parámetros de consulta
        get("/cos", (req, res) -> {
            String angleParam = req.queryParams("angle");
            if (angleParam != null) {
                double angle = Double.parseDouble(angleParam);
                Calculator cosCalc = new Cos();
                return "Cos: " + cosCalc.calculate(new double[]{angle});
            } else {
                return "Parámetro 'angle' no proporcionado.";
            }
        });

        // Ruta para calcular la magnitud de un vector usando parámetros de consulta
        get("/magnitude", (req, res) -> {
            String xParam = req.queryParams("x");
            String yParam = req.queryParams("y");
            if (xParam != null && yParam != null) {
                double x = Double.parseDouble(xParam);
                double y = Double.parseDouble(yParam);
                Calculator magnitudCalc = new Magnitude();
                return "Magnitude: " + magnitudCalc.calculate(new double[]{x, y});
            } else {
                return "Parámetros 'x' o 'y' no proporcionados.";
            }
        });

        // Ruta para verificar si una cadena es un palíndromo usando parámetros de consulta
        get("/palindrome", (req, res) -> {
            String strParam = req.queryParams("str");
            if (strParam != null) {
                StringBuilder sb = new StringBuilder(strParam);
                return "Palindrome: " + (strParam.contentEquals(sb.reverse()) ? "Sí" : "No :(");
            } else {
                return "Parámetro 'str' no proporcionado.";
            }
        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
