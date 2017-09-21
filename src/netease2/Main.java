package netease2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //注意while处理多个case
        String str = in.next();

        int num = str.length() / 2;
        //System.out.println(str);
        //System.out.println(str.length());
        ArrayList<String> result = generateParenthesis(num);


        //System.out.println(result);

        HashMap<Integer, Integer> map = new HashMap<>();
        int len = result.size();
        for (int i = 0; i < len; i++) {
            if (!result.get(i).equals(str)) {
                //int count = longestCommonSubstring(result.get(i), str);
                int count = longestCommonSubsequence(result.get(i), str);
                //System.out.println(count);
                if (!map.containsKey(count)) {
                    map.put(count, 1);
                } else {
                    int temp = map.get(count);
                    map.put(count, temp + 1);
                }
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int max = Integer.MIN_VALUE;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int value = entry.getValue();
            max = Math.max(max, value);
        }

        System.out.println(max);

    }

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }

    public static void helper(ArrayList<String> result,
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

    public static int longestCommonSubsequence(String A, String B) {
        // write your code here
        int n = A.length();
        int m = B.length();
        int f[][] = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(A.charAt(i - 1) == B.charAt(j - 1))
                    f[i][j] = f[i - 1][j - 1] + 1;
            }
        }
        return f[n][m];
    }
}