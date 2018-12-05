package swordOffer.Problem4;

public class No4 {

    public static void main(String[] args) {
        String str = "We are happy";
        String str2 = "Wearehappy";
        char[] chars = str.toCharArray();
        char[] chars1 = str2.toCharArray();
        System.out.println(change(chars));
        System.out.println(change(chars1));
    }

    /**
     *首先判断字符串数组中' '的个数，如果' '个数为0，直接返回原字符串，构造一个新的字符串数组，包含更换的字符串长度，最后从末尾开始放入新的字符串数组，
     * 遇到空格加入替换的字符串
     * @param charArray
     * @return
     */
    private static String change(char[] charArray) {
        int len = charArray.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == ' ') {
                count = count + 1;
            }
        }

        if (count == 0) {
            return new String(charArray);
        }

        char[] temp = new char[len + 2 * count];

        int current = len + 2 * count - 1;
        int previous = len - 1;

        while (previous >= 0) {
            if (charArray[previous] == ' '){
                temp[current] = '0';
                temp[current - 1] = '2';
                temp[current - 2] = '%';
                current = current - 3;
            } else {
                temp[current] = charArray[previous];
                current = current - 1;
            }

            previous = previous - 1;
        }

        return new String(temp);
    }
}
