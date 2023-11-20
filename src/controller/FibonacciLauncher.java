package controller;

/**
 * @author Marc Ledermann
 * <m.ledermann@st.hanze.nl>
 * Purpose of the program:
 **/
public class FibonacciLauncher {
    public static void main(String[] args) {
        // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,...
        int fibonacciNumber = 40;

        long startTime = System.nanoTime();
        fibonacciNaive(fibonacciNumber);
        long fibonacciNaiveTime = System.nanoTime();
        fibonacciLessNaive(fibonacciNumber);
        long end = System.nanoTime();

        System.out.printf("\nFib Naive:     %20d", fibonacciNaiveTime - startTime);
        System.out.printf("\nFib lessNaive: %20d", end - fibonacciNaiveTime);

    }

    private static int fibonacciNaive(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }

        int fibMin1 = fibonacciNaive(number - 1);
        int fibMin2 = fibonacciNaive(number - 2);

        return fibMin1 + fibMin2;
    }

    public static long fibonacciLessNaive(int number) {
        long[] fibonacci = new long[number + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        fibonacciLessNaive(number, fibonacci);

        return fibonacci[number];
    }

    private static void fibonacciLessNaive(int number, long[] fibonacci) {
        if (fibonacci[number] != 0) {
            return;
        }

        fibonacciLessNaive(number - 1, fibonacci);
        fibonacci[number] = fibonacci[number - 2] + fibonacci[number - 1];
    }
}
