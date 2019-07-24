package zhaoTest;

import java.util.Random;

/**
 * Created by zhaochao on 2019/7/24.
 */

public class IntReverse {
    public static void main(String[] args) {
        Random random = new Random();

        IntReverse intReverse = new IntReverse();
        int a = (int) (Math.random() * 2 + 1);
        int aa = (int) (Math.pow(-1, a));  // 随机生成正负号
        int bb = random.nextInt(1000) * aa;
        System.out.println(bb);
        System.out.println(intReverse.reverse(bb));


    }

    private int reverse(int mm) {
        int n = 0;
        int flag = 0; // 标识第一次进入循环的标识位
        while (mm / 10 != 0) {
            if (flag == 0) {
                n = mm % 10;
                flag = 1;
            } else {
                n = 10 * n + mm % 10;
            }
            mm = mm / 10;
        }
        return 10 * n + mm;


    }


}
