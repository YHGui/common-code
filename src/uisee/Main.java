package uisee;

public class Main {
    public static int solution(int N) {
        for (int i = 1; i < N / 2; i++) {
            if (isSparsed(i) && (isSparsed(N - i))) {
                //System.out.println(i);
                return i;
            }
        }
        return -1;
    }
    static  boolean isSparsed(int num) {
        if ((num & (num >> 1)) != 0) {
            return false;
        }

        return true;
    }
}
