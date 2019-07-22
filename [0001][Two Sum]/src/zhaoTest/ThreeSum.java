package zhaoTest;

import java.util.*;


/*
 *内容：
 * 任意给定一个数组,要求找出数组中任意三个数之和等于给定特定数，输出这三个数，并要求不重复输出
 *
 *
 *思路：
 * 先对数组进行排序,三重循环,判断相加和,并用一个Map<Integer, Set>记录已经出现过的组合
 * （原理：前两个数唯一确定第三个数）
 *
 *
 * */

public class ThreeSum {
    int[] bb = {1, 1, 1, 1, 3, 7, 7, 4, 5, 5, 6, 13, 8, 11, 23, 13, 5, 13, 10, 19, 19};
    int target = 15;


    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        TwoSum twoSum = new TwoSum();
        int[] aa = twoSum.paixu(threeSum.bb);
        threeSum.qiuSanGeShu(aa, threeSum.target);
        System.out.println();


    }

    private void qiuSanGeShu(int[] cc, int targets) {

        Map<Integer, Set> map = new HashMap<>();
        for (int i = 0; i < cc.length; i++) {
            for (int j = i + 1; j < cc.length; j++) {
                for (int k = j + 1; k < cc.length; k++) {
                    if ((cc[i] + cc[j] + cc[k]) == target) {
                        if (map.get(cc[i]) != null && map.get(cc[i]).contains(cc[j])) {
                            continue;
                        }

                        if (map.get(cc[i]) == null) {
                            Set value = new HashSet();
                            value.add(cc[j]);
                            map.put(cc[i], value);
                            System.out.println(cc[i] + "    " + cc[j] + "     " + cc[k]);
                            continue;
                        }

                        Set value = new HashSet();
                        value = map.get(cc[i]);
                        value.add(cc[j]);
                        map.put(cc[i], value);
                        System.out.println(cc[i] + "    " + cc[j] + "     " + cc[k]);

                    }

                }
            }

        }


    }


}
