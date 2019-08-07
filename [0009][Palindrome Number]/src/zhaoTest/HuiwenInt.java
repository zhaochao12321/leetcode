package zhaoTest;

/**
 * Created by zhaochao on 2019/7/25.
 * *
 * * 题目大意
 * * 判断一个数字是否是回访字数，不要使用额外的空间。
 * Coud you solve it without converting the integer to a string?
 */

public class HuiwenInt {


    public static void main(String[] args) {
        HuiwenInt huiwenInt = new HuiwenInt();
        huiwenInt.isPalindrome(2222222);

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {                 // 负数直接返回false
            return false;
        }
        boolean isPalindrome = true;
        int nDigits = (int) Math.log10(x) + 1; // 通过对数函数获取int位数,之前一定要进行int 强转,要不回事小数
        int gaowei = (int) Math.pow(10, nDigits - 1);    // 用作获取高位的除数
        int diwei = 10;                                  // 用作获取地位的余数
        System.out.println(nDigits / 2);
        for (int i = 0; i < nDigits / 2; i++) {
            if (((x / gaowei) < 10 ? (x / gaowei) : (x / gaowei) % 10) != yougao(x, diwei)) {
                isPalindrome = false;

                break;
            }
            gaowei = gaowei / 10;
            diwei = diwei * 10;

        }


        return isPalindrome;
    }

    private int yougao(int number, int yushu) {                  // 取右边部分高位
        int aa = number % yushu;
        if ((int) Math.log10(yushu) > (int) Math.log10(aa) + 1) {    // 取余后的位数应该为 yushu 的位数减一，如果不是,说明最高位为0
            return 0;
        }
        if (aa < 10) {
            return aa;
        }
        System.out.println(aa / (int) (Math.pow(10, (int) Math.log10(aa))));
        return aa / (int) (Math.pow(10, (int) Math.log10(aa)));
    }

//    private int zuodi(int number, int chushu) {                   // 取左边部分低位 (优化后本方法改为三目运算符书写)
//        int shang = number / chushu;
//        if (shang < 10) {
//            return shang;
//        }
//
//        System.out.println(shang % 10);
//        return shang % 10;
//
//    }

}
