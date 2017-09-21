package lintcode.week2;


public class No9 {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    private static long fibonacci(int n) {
        if (n < 2) {
            return 1;
        }

        long fib1 = 1;
        long fib2 = 1;
        long fibN = 0;
        for (int i = 2; i <= n ; i++) {
            fibN = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibN;
        }
        return fibN;
    }
}
