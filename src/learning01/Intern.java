package learning01;

/**
 * Created by Katsura on 2017/2/22.
 */
public class Intern {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = "a";
        String str4 = "bc";
        String str5 = str3 + str4;
        String str6 = new String(str1);

        System.out.println("------no intern-----");
        System.out.println("str1 == str2 ?");
        System.out.println(str1 == str2);
        System.out.println("str1 == str5 ?");
        System.out.println(str1 == str5);
        System.out.println("str1 == str6 ?");
        System.out.println(str1 == str6);
        System.out.println();

        System.out.println("------intern-----");
        System.out.println("str1 == str2 ?");
        System.out.println(str1.intern() == str2.intern());
        System.out.println("str1 == str5 ?");
        System.out.println(str1.intern() == str5.intern());
        System.out.println("str1 == str6 ?");
        System.out.println(str1.intern() == str6.intern());
        System.out.println();
    }
}
