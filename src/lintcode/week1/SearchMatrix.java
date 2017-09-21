package lintcode.week1;


public class SearchMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9},
                       {2, 4, 9, 12},
                       {4, 7, 10, 13},
                       {6, 8, 11, 15}};
        System.out.println(searchMatrix(arr, 7));
    }

    private static boolean searchMatrix(int[][] arr, int target) {
        int a = arr[0].length;
        int b = arr.length;
        int i = 0;
        int j = a - 1;

        while (i <= b - 1 && j >= 0) {
            if (target == arr[i][j]) {
                return true;
            }
            if (target < arr[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }



    /*
    public static boolean  searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        int end = row * column - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / column][mid % column] == target) {
                return true;
            } else if (matrix[mid / column][mid % column] > target){
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[start / column][start % column] == target) {
            return true;
        }
        if (matrix[end / column][end % column] == target) {
            return true;
        }

        return false;
    }
    */
}
