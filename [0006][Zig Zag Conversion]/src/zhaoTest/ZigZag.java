package zhaoTest;

/**
 * Created by zhaochao on 2019/8/6.
 * <p>
 * N 字形显示字符串
 * <p>
 * 思路：二维数组
 */

public class ZigZag {


    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
        String string = zigZag.convert("PAYPALISHIRING", 3);
        System.out.println(string);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int lieshu = s.length();
        String[][] shuzu = new String[numRows][lieshu];

        for (int i = 0; i < s.length(); i++) {
            int m = 0;      // 行号
            int n = 0;      // 列号
            int xunhuanShu = 0;    //   第几个循环体
            xunhuanShu = (i) / (2 * numRows - 2);      // 是第几个循环体
            n = xunhuanShu * (numRows - 1);         // 本循环体开始的列数

            if (i % (2 * numRows - 2) < numRows) {      // 在本循环的竖线部分
                    System.out.println("(" + i % (2 * numRows - 2) + "   " + n + ")   :" + String.valueOf(s.charAt(i)));
                shuzu[i % (2 * numRows - 2)][n] = String.valueOf(s.charAt(i));
            } else {
                m = numRows - 1;      // 置行号为最下位
                for (int j = 0; j < (i % (2 * numRows - 2) + 1) - numRows; j++) {
                    m = m - 1;
                    n = n + 1;
                }
                shuzu[m][n] = String.valueOf(s.charAt(i));
                  System.out.println("(" + m + "   " + n + ")   :" + String.valueOf(s.charAt(i)));

            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            for (int l = 0; l < lieshu; l++) {
                if ((shuzu[k][l]) != null) {           // 提出数组中的空单元,按行输出
                    stringBuilder.append(shuzu[k][l]);
                }
            }
        }
        return stringBuilder.toString();

    }
}
