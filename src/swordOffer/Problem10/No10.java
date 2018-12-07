package swordOffer.Problem10;

public class No10 {

    public static void main(String[] args) {

        System.out.println(getOneNum(9));
    }

    /**
     * 把一个整数减去1，再和原整数做与运算，会把整数最右边的一个1变成0，那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作
     * @param n
     * @return
     */
    private static int getOneNum(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = n & (n - 1);
        }

        return cnt;
    }
}
