package huawei;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.next();
            char source = in.next().charAt(0);
            char replace = in.next().charAt(0);
            getReplacement(string, source, replace);
        }
    }

    static ArrayList<Sort> listAll = new ArrayList<>();
    public static String getReplacement(String string, char source, char replace) {
        if (string == null || source == ' ' || replace == ' ')
            return "";

        replace(string.toCharArray(), source, replace, 0, string.length() - 1, 0);

        Sort sort = new Sort();
        sort.str = string;
        sort.cnt = 0;
        listAll.add(sort);

        Collections.sort(listAll, new Comparator<Sort>() {
            @Override
            public int compare(Sort o1, Sort o2) {
                return o1.cnt - o2.cnt;
            }
        });

        if(listAll.size() != 0){
            for(int i = 0; i < listAll.size(); i++)
                System.out.println(listAll.get(i).str);
        }

        return null;
    }

    public static void replace(char[] chars, char source, char replace, int begin, int end, int cnt) {
        if (begin == end) {
            if(chars[end] == source){
                chars[end] = replace;
                ArrayList<Character> list = new ArrayList<>();
                StringBuffer sb = new StringBuffer();
                for(Character c : chars)
                    sb.append(c);
                Sort sort = new Sort();
                sort.str = sb.toString();
                sort.cnt = cnt + (int) Math.pow(2, end - begin);
                listAll.add(sort);
            }

            return;
        } else {
            for (int i = begin; i <= end; i++) {
                if (chars[i] == source) {
                    chars[i] = replace;
                    StringBuffer sb = new StringBuffer();
                    for(Character c : chars)
                        sb.append(c);
                    Sort sort = new Sort();
                    sort.str = sb.toString();
                    sort.cnt = cnt + (int) Math.pow(2, end - i);
                    if(!listAll.contains(sort))
                        listAll.add(sort);
                    replace(chars, source, replace, begin + 1, end, (int ) Math.pow(2, end - i));
                    chars[i] = source;
                }
            }
        }
    }

    static class Sort{
        private String str;
        private int cnt;

    }
}
