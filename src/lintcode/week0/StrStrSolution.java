package lintcode.week0;

/**
 * Created by Katsura on 2017/3/5.
 */
class StrStrSolution {
    public static final int BASE = 1000000;
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public static int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null) {
            return -1;
        }
        //首先判断null的情况，有null则return -1

        //在没有代码提示的时候，之前String的length老忘记它是一个方法，而非field
        //以免charAt()溢出，字符串长度相减，第二重循环又会加上减掉的，因此不影响
        //时间复杂度为O(M * N)
        for (int sourceIndex = 0; sourceIndex < source.length() - target.length() + 1; sourceIndex++) {
            int targetIndex = 0;
            for (targetIndex = 0; targetIndex < target.length(); targetIndex++) {
                if (source.charAt(sourceIndex + targetIndex) != target.charAt(targetIndex)) {
                    break;
                    //出现不匹配则立马退出循环
                }
            }
            if (targetIndex == target.length()) {
                return sourceIndex;
                //然后判断是否已经全部轮询target，是的话就return当前source的index
            }
        }
        return -1;
    }

    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    /*
    * Rabin Karp算法实现时间复杂度为O(M + N)
    *通过比较不同的字符串的hashcode值来判断两个字符串是否相等，当然还做了double check来判断是否相同
    * 使用hash function(进制转换)，当然hash function有可能出现冲突，因此需要做double check
    * abcde = (a×31^4+b×31^3+c×31^2+d×31+e×1) % 10^6 字符串转换为整数，但一直是同一个值(通用的hash function)
    * 31：magic number 经验值，效率高
    * 大部分hash值不同的时间加速了，只有在找到答案的时候才double try，从而时间复杂度变为O(M + N)
    * */
    public static int strStr2(String source, String target) {

        if (source == null || target == null) {
            return -1;
        }
        int m = target.length();
        if (m == 0) {
            return 0;
        }

        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }
        int targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }

        int hashCode = 0;
        for (int i = 0; i < source.length(); i++) {
            //先加上字符 abc + d
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            if (i < m - 1) {
                continue;
            }
            if (i >= m) {
                //剪掉字符 abcd - a
                hashCode = hashCode - (source.charAt(i - m) * power) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }

            if (hashCode == targetCode) {
                //double check
                /*
                substring(int beginIndex, int endIndex)
                其中beginIndex为起始下标，包括在内，endIndex为结尾处索引，不包括在内
                * */
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //test
        System.out.println(strStr("source", "target"));
        System.out.println(strStr("abcdabcdefg", "bcd"));

        System.out.println(strStr2("source", "target"));
        System.out.println(strStr("abcdabcdefg", "bcd"));
    }
}
