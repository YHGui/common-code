package swordOffer.Problem9;

public class No9 {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    private static long fibRecur(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("the param is less than 0");
        }

        if (0 == n) {
            return 0;
        }

        if (1 == n) {
            return 1;
        }

        return fibRecur(n - 1) + fibRecur(n - 2);
    }

    private static long fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("the param is less than 0");
        }

        if (0 == n) {
            return 0;
        }

        if (1 == n) {
            return 1;
        }

        int fib1 = 0;
        int fib2 = 1;
        int fibN = 0;

        for (int i = 2; i <= n; i++) {
            fibN = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibN;
        }

        return fibN;
    }
}
