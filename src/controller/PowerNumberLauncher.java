package controller;

/**
 * @author Marc Ledermann
 * <m.ledermann@st.hanze.nl>
 * Purpose of the program:
 **/
public class PowerNumberLauncher {
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        iterativePower(4, 20);
        long intermediate = System.nanoTime();
        recursivePower(4, 20);
        long endTime = System.nanoTime();

        System.out.println("Iterative: " + (intermediate - startTime));
        System.out.println("Recursive: " + (endTime - intermediate));

    }

    public static int iterativePower(int base, int exponent) {
        int power = 1;

        for (int i = 0; i < exponent; i++) {
            power *= base;
        }
        return power;
    }


    public static int recursivePower(int base, int exponent) {

        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent numbers for negative heights are undefined.");
        } else if (exponent == 0) {
            return 1;
        }

        return base * recursivePower(base, exponent - 1);
    }
}
