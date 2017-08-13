package lintcode.week0;

import java.util.ArrayList;

/**
 * Created by Katsura on 2017/4/5.
 */
public class GPSolution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }

    public void helper(ArrayList<String> result,
                       String paren, // current paren
                       int left,     // how many left paren we need to add
                       int right) {  // how many right paren we need to add
        if (left == 0 && right == 0) {
            result.add(paren);
            return;
        }

        if (left > 0) {
            helper(result, paren + "(", left - 1, right);
        }

        if (right > 0 && left < right) {
            helper(result, paren + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        GPSolution gpSolution = new GPSolution();
        System.out.println(gpSolution.generateParenthesis(3));
    }
}
