package huawei;


import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        char[] charArr = str[0].toCharArray();
        char source = str[1].toCharArray()[0];
        char target = str[2].toCharArray()[0];

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == source) {
                list.add(i);
            }
        }
        int num = 1;
        for (int i = 0; i < list.size(); i++) {
            num = num * 2;
        }

        for (int i = 0; i < num - 1; i++) {
            
        }


    }
}
