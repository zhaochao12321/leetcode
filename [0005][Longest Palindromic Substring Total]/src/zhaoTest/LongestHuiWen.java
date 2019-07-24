package zhaoTest;

import java.util.Map;
import java.util.Random;

/**
 * Created by zhaochao on 2019/7/23.
 * <p>
 * <p>
 * <p>
 * 给定一个字符串,长短不限,内容不限,找出其中最长的一个回文字符串。
 */

public class LongestHuiWen {
    public static void main(String[] args) {
        LongestHuiWen longestHuiWen = new LongestHuiWen();
        // String s = "12234565665341234qwertyuytrewq4321";  给定字符串
        String s = longestHuiWen.randomString(100); // 随机生成100位字符串
        CentreAndlength centreAndlength = longestHuiWen.fetchCentreAndLength(s);
        System.out.println(s.substring(centreAndlength.getCentre() - centreAndlength.getLength(), 1 + centreAndlength.getCentre() + centreAndlength.getLength()));

    }


    private CentreAndlength fetchCentreAndLength(String string) {
        CentreAndlength centreAndlength = new CentreAndlength();

        for (int i = 0; i < string.length(); i++) {
            int banjinMax = i < (string.length() - i) ? i : string.length() - i; // 最大半径
            int banjin = 0;
            for (int j = 1; j < banjinMax; j++) {
                if (string.charAt(i - j) == string.charAt(i + j)) {
                    banjin++;
                    continue;
                }

                break;
            }

            if (centreAndlength.getLength() < banjin) {
                centreAndlength.setCentre(i);
                centreAndlength.setLength(banjin);
            }


        }


        return centreAndlength;
    }


    private String randomString(int length) {
        //  String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";   全量字符串,生成回文的概率较低
        String str = "abcdefghijklmnopqrstuvwxyz"; // 全小写字符串,生成回文的概率较高
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            //  int number = random.nextInt(62);  对应全量字符串
            int number = random.nextInt(26);  // 对应全小写字符串
            sb.append(str.charAt(number));
        }
        return sb.toString();


    }

    /**
     * 记录圆心及半径的内部类
     */
    class CentreAndlength {
        private int centre;
        private int length;


        public int getCentre() {
            return centre;
        }

        public void setCentre(int centre) {
            this.centre = centre;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }

}
