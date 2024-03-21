package edu.arep.funciones;

public class Sin implements Calculator {
    /**
     * Calculate the sin of a given value in degrees.
     *
     * @param  values   an array containing the value in degrees
     * @return          the sine of the given value
     */
    @Override
    public double calculate(double[] values) {
        if (values.length != 1) {
            throw new IllegalArgumentException("Sin necesita exactamente un valor para calcular.");
        }
        return Math.sin(Math.toRadians(values[0]));
    }
}

