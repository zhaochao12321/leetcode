package zhaoTest;

import java.util.Random;

/**
 * Created by zhaochao on 2019/7/24.
 * <p>
 * ����һ������������з�ת
 * <p>
 * range: [?231,  231 ? 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */

public class IntReverse {
    public static void main(String[] args) {
        Random random = new Random();

        IntReverse intReverse = new IntReverse();
        int a = (int) (Math.random() * 2 + 1);
        int aa = (int) (Math.pow(-1, a));  // �������������
        int bb = random.nextInt(1000) * aa;
        //   System.out.println(bb);
        //  System.out.println(intReverse.reverse(bb));
        System.out.println(intReverse.reverse(1534236469

        ));


    }

    private int reverse(int x) {
        long shangjie = (long) Math.pow(2, 31) - 1;     // int �ı�ʾ����
        long xiajie = -(long) Math.pow(2, 31);          // int �ı�ʾ����
        int n = 0;
        int flag = 0; // ��ʶ��һ�ν���ѭ���ı�ʶλ
        while (x / 10 != 0) {
            if (flag == 0) {
                n = x % 10;
                flag = 1;
            } else {
                if (n > (shangjie - x % 10) / 10 || n < (xiajie - x % 10) / 10) {
                    return 0;
                }
                n = 10 * n + x % 10;
            }
            x = x / 10;
        }
        if (n > (shangjie - x) / 10 || n < (xiajie - x) / 10) {
            return 0;
        }
        return 10 * n + x;

    }


}
