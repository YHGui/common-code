package lintcode.week2;


public class No4 {
    public static void main(String[] args) {
        String str = "We are happy";
        char[] charArr = str.toCharArray();
        System.out.println(change(charArr));
    }

    private static String change(char[] charArr) {
        int num = charArr.length;
        
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (charArr[i] == ' ') {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }

        int newNum = num + 2 * count;
        char[] temp = new char[newNum];
        int index = num - 1;
        int newIndex = newNum - 1;
        while (index >= 0) {
            if (charArr[index] == ' ') {
                temp[newIndex] = '0';
                temp[newIndex - 1] = '2';
                temp[newIndex - 2] = '%';
                newIndex = newIndex - 3;
            } else {
                temp[newIndex] = charArr[index];
                newIndex--;
            }
            index--;
        }
        return new String(temp);
    }
}
