package swordOffer.Problem9;

public class No9_2 {

    public static void main(String[] args) {
        System.out.println(getMethodNumberRecur(5));
        System.out.println(getMethodNumber(5));
    }

    private static int getMethodNumberRecur(int n) {
        if (0 == n) {
            return 0;
        }

        if (1 == n) {
            return 1;
        }

        if (2 == n) {
            return 2;
        }

        return getMethodNumberRecur(n - 1) + getMethodNumberRecur(n - 2);
    }

    private static int getMethodNumber(int n) {
        if (0 == n) {
            return 0;
        }

        if (1 == n) {
            return 1;
        }

        if (2 == n) {
            return 2;
        }

        int fib1 = 1;
        int fib2 = 2;
        int fibN = 0;

        for (int i = 3; i <= n; i++) {
            fibN = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibN;
        }

        return fibN;
    }
}
