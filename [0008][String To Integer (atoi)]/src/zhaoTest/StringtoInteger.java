package zhaoTest;

/**
 * Created by zhaochao on 2019/8/6.
 */

public class StringtoInteger {
    public static void main(String[] args) {
        StringtoInteger stringtoInteger = new StringtoInteger();
        int result = stringtoInteger.myAtoi("-2147483649"

        );
    }

    public int myAtoi(String str) {
        int shangjie = (int) Math.pow(2, 31);     // 上限
        int xiajie = -(int) Math.pow(2, 31) - 1;          // 下限
        int flag = 0;                       // 正负数标识位
        if (str == null || "".equals(str)) {                  // 排空
            return 0;
        }
        int resultInt = 0;
        String intString = "-+0123456789";
        String numberString = "0123456789";
        str = str.trim();
        if (str.length() > 0 && intString.indexOf(str.charAt(0)) < -1) {         // String开头不合法,直接返回0
            return 0;
        }

        for (int i = 0; i < str.length(); i++) {
            if (intString.indexOf(str.charAt(i)) > -1) {
                if (i == 0) {
                    if ("-".indexOf(str.charAt(i)) > -1) {
                        flag = -1;                                // 负数为-1

                    } else if ("+".indexOf(str.charAt(i)) > -1) {
                        flag = 1;                                  // 正数为1 或0
                    } else {
                        resultInt = Integer.parseInt(String.valueOf(str.charAt(i)));
                    }

                } else if (i == 1 && numberString.indexOf(str.charAt(i)) > -1) {
                    if (flag != 0) {                                      // 第一位为符号位
                        resultInt = Integer.parseInt(String.valueOf(str.charAt(i)));
                    } else {                                              // 第一位为数字位
                        resultInt = resultInt * 10 + Integer.parseInt(String.valueOf(str.charAt(i)));
                    }
                } else if (numberString.indexOf(str.charAt(i)) > -1) {
                    if (verification(resultInt, Integer.parseInt(String.valueOf(str.charAt(i))), flag) == 1) {
                        if (flag == -1) {
                            return xiajie;
                        } else {
                            return shangjie;
                        }
                    }
                    resultInt = resultInt * 10 + Integer.parseInt(String.valueOf(str.charAt(i)));
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        if (flag == 0) {
            flag = 1;
        }
        return resultInt * flag;

    }

    /**
     * int 是否越界检验算法
     *
     * @param number        需要校验的数字
     * @param valueOfCharAt 需要校验的最低位
     * @param flag          正负标志
     * @return
     */

    private int verification(int number, int valueOfCharAt, int flag) {
        long shangjie = (long) Math.pow(2, 31) - 1;     // 上限
        long xiajie = -(long) Math.pow(2, 31);          // 下限
        int result = 0;
        if (flag == -1) {                               // 负数校验
            if (((-number) < xiajie / 10) || (-number == (xiajie / 10) && valueOfCharAt > 8)) {
                result = 1;
            }
        } else {                                        // 正数校验
            if ((number > shangjie / 10) || ((number == shangjie / 10) && valueOfCharAt > 7)) {
                result = 1;
            }
        }
        return result;
    }
}
