package controller;

/**
 * @author Marc Ledermann
 * <m.ledermann@st.hanze.nl>
 * Purpose of the program:
 **/
public class TriangleNumberLauncher {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        triangleNumber(20);
        long intermediate = System.nanoTime();
        recursiveTriangleNumber(20);
        long endTime = System.nanoTime();

        System.out.println("Triangle:  " + (intermediate - startTime));
        System.out.println("Recursive: " + (endTime - intermediate));


        System.out.println(triangleNumber(4));
        System.out.println(recursiveTriangleNumber(4));
    }

    private static int triangleNumber(int height) {
        int triangleNumber = 0;

        for (int i = 0; i <= height; i++) {
            triangleNumber += i;
        }

        return triangleNumber;
    }

    public static int recursiveTriangleNumber(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("Triangle numbers for negative heights are undefined.");
        } else if (height == 0) {
            return 0;
        }

        return height + recursiveTriangleNumber(height - 1);
    }
}
