package learning01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Katsura on 2017/3/24.
 */
public class Main {
    public static void main(String[] args) {
        Main daAdda = new Main();
        Scanner in = new Scanner(System.in).useDelimiter("\\D");//.useDelimiter(",");
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(daAdda.reverseAdd(a,b));
        }
//        int a = in.nextInt();
//        int b = in.nextInt();
//        System.out.println(daAdda.reverseAdd(a, b));
    }

    public int reverseAdd(int a, int b) {
        if (a < 1 || a > 70000 || b < 1 || b > 70000) {
            return -1;
        }
        return reverseData(a) + reverseData(b);

    }

    public int reverseData(int data) {
        List<Integer> list = new ArrayList<>();
        while (data > 0) {
            int temp = data % 10;
            data = data / 10;
            list.add(temp);
        }
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0 && ans == 0)
                continue;
            if (ans == 0)
                ans += list.get(i);
            else
                ans = ans * 10 + list.get(i);
        }
        return ans;
    }
}
