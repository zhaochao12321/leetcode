package zhaoTest;

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
        String s = "ccc";
        //   String s = longestHuiWen.randomString(100); // 随机生成100位字符串

        String returns = longestHuiWen.fetchCentreAndLength(s);

    }

    private String fetchCentreAndLength(String s) {
        if ("".equals(s)) {
            return "";
        }

        CentreAndlength centreAndlength = new CentreAndlength();
        centreAndlength.setFlag(3);

        for (int i = 0; i < s.length(); i++) {                         // 以某字符对称
            int banjinMax = i < (s.length() - i-1) ? i : s.length() - i-1; // 最大半径
            int banjin = 0;
            for (int j = 1; j < banjinMax+1; j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    banjin++;
                    continue;
                }
                break;
            }
            if (centreAndlength.getLength() < banjin) {
                centreAndlength.setCentre(i);
                centreAndlength.setLength(banjin);
                centreAndlength.setFlag(1);       // 根据元素对称    flag 为1
            }
        }


        for (int j = 0; j < s.length(); j++) {                          // 以某个中缝对称
            int banjinMax = j + 1 < (s.length() - j - 1) ? j + 1 : s.length() - j - 1; // 最大半径
            int banjin = 0;
            for (int k = 1; k < banjinMax + 1; k++) {                     // 移动半径
                if (s.charAt(j - k + 1) == s.charAt(j + k)) {
                    banjin++;
                    continue;
                }

                break;
            }
            if (centreAndlength.getLength() < banjin) {
                centreAndlength.setCentre(j);
                centreAndlength.setLength(banjin);
                centreAndlength.setFlag(0);            // 根据线对称为 0
            }

        }

        if (centreAndlength.getFlag() == 1) {     // 由元素对称
            return s.substring(centreAndlength.getCentre() - centreAndlength.getLength(), 1 + centreAndlength.getCentre() + centreAndlength.getLength());
        } else if (centreAndlength.getFlag() == 0) {
            return s.substring(centreAndlength.getCentre() - centreAndlength.getLength() + 1, 1 + centreAndlength.getCentre() + centreAndlength.getLength());

        }
        return s.substring(0, 1);

    }


    /**
     * 生成随机字符串
     *
     * @param length 字符串长度
     * @return
     */

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
        private int flag;      // 区分根据某元素对称和根据缝对称


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

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }
    }
}
