package edu.arep.funciones;

public class Magnitude implements Calculator {
    /**
     * Calculate the square root of the sum of squares of the input values.
     *
     * @param  values   an array of double values
     * @return         the square root of the sum of squares
     */
    @Override
    public double calculate(double[] values) {
        double sum = 0;
        for (double value : values) {
            sum += value * value;
        }
        return Math.sqrt(sum);
    }
}
