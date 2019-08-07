package zhaoTest;

import org.omg.CORBA.INTERNAL;

/**
 * Created by zhaochao on 2019/8/1.
 */

public class Solution00 {

    public static void main(String[] args) {
        Solution00 solution = new Solution00();  // abccccccbad
        int result = solution.lengthOfLongestSubstring("");
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.substring(i, j).indexOf(s.charAt(j)) > -1) {
                    if ((j - i) > (end - start) || end == 0) {
                        end = j - 1;
                        start = i;

                    }
                    break;
                }

                if (j == (s.length() - 1) && (j - i) > (end - start)) {
                    start = i;
                    end = s.length() - 1;
                }
            }

        }
        return end - start + 1;
    }
}
