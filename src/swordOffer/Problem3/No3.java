package swordOffer.Problem3;

public class No3 {

    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},
                       {2,4,9,12},
                       {4,7,10,13},
                       {6,8,11,15}};
        System.out.println(search(arr, 7));
    }

    /**
     * 从右上角数开始考虑，如果当前值大于目标值说明目标值应该位于数组左边部分，则列往左移，行不变，
     * 否则如果当前值小于目标值，说明目标值位于整个数组下部分，则行下移，列不变，整个思想是一次排除掉一行/列可能性
     * @param arr
     * @param value
     * @return
     */
    private static boolean search(int[][] arr, int value) {
        int col = arr[0].length;
        int row = arr.length;
        int i = 0;
        int j = col - 1;

        while (i <= row - 1 && j >= 0) {
            if (arr[i][j] == value) {
                return true;
            }

            if (arr[i][j] > value) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
