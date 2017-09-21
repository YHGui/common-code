package lintcode.week0;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = in.next();
            }
            int m = in.nextInt();
            String[] target = new String[m];
            for (int i = 0; i < m; i++) {
                target[i] = in.next();
            }

            for (int i = 0; i < m; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    if (isChild(strs[j], target[i])) {
                        sum += 1;
                    }
                }
                System.out.println(sum);
            }

        }
    }

    public static boolean isChild(String source, String target) {
        if (source == null || target == null) {
            return false;
        }


        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }

            if (j == target.length()) {
                return true;
            }
        }
        return false;
    }

}
