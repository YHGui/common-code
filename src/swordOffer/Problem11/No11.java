package swordOffer.Problem11;

public class No11 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(power(2.0, 10));
        System.out.println(System.currentTimeMillis());
        //System.out.println(powerWithExponent2(2.0, -10));
    }

    /**
     * 需要区分指数的符号，如果指数为负整数，将base转为倒数，并将exponent转为对应的正整数
     * @param base
     * @param exponent
     * @return
     */
    private static double power(double base, int exponent) {

        double res;

        if (exponent == 0) {
            return 1.0;
        }

        if (exponent < 0) {
            res = powerWithExponent2(1.0 / base, -exponent);
        } else {
            res = powerWithExponent2(base, exponent);
        }

        return res;
    }

    /**
     * 连续想乘
     * @param base
     * @param exponent
     * @return
     */
    private static double powerWithExponent(double base, int exponent){
        double res = 1.0;
        for (int i = 1; i <= exponent; i++) {
            res = res * base;
        }

        return res;
    }

    /**
     * 采用递归的思想，二分指数，然后将二分后的res做平方，以及计算均分之后产生的余数效果，能够明显减少运行时间，变为log(n)
     * @param base
     * @param exponent
     * @return
     */
    private static double powerWithExponent2(double base, int exponent) {
        if (0 == exponent) {
            return 1.0;
        }

        if (1 == exponent) {
            return base;
        }

        double res = powerWithExponent2(base, exponent >> 1);
        res *= res;

        if (1 == (exponent & 0x1)) {
            res *= base;
        }

        return res;
    }


}
