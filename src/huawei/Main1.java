package huawei;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split("-");
        String[] str2 = sc.nextLine().split("-");
        int len1 = str1.length;
        int len2 = str2.length;
        int i = len1 - 1;
        int j = len2 - 1;
        int count = 0;
        String last = null;
        while (i >= 0 && j >= 0) {
            if (str1[i].equals(str2[j])) {
                count = count + 1;
                last = str1[i];
                i--;
                j--;
            } else {
                break;
            }
        }
        if (count == 0) {
            count = 0;
            last = "0";
        } else {
            count = count - 1;
        }

        System.out.print(last);
        System.out.print(" ");
        System.out.print(count);
    }
}
