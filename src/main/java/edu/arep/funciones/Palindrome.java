package edu.arep.funciones;

public class Palindrome implements Calculator {

    /**
     * Calculate if the input value is a palindrome.
     *
     * @param  values	array of values to be checked for palindrome
     * @return         1 if the value is a palindrome, 0 otherwise
     */
    @Override
    public double calculate(double[] values) {
        if (values.length != 1) {
            throw new IllegalArgumentException("Palindromo necesita exactamente un valor para calcular.");
        }
        String str = String.valueOf(values[0]);
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();
        return str.equals(reversed) ? 1 : 0;
    }
}

