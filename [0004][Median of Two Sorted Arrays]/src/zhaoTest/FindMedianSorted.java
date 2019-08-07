package zhaoTest;


/**
 * Created by zhaochao on 2019/7/23.
 * 题目大意：
 * 两个排序数组，找这两个排序数组的中位数，时间复杂度为O(log(m+n))
 * <p>
 * 验证准确性,数组长度,数组内容均为随机生成
 */

public class FindMedianSorted {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double end = 0;

        int[] sortNums = paixu(nums1, nums2);
        if (sortNums.length % 2 == 0) {               // 总数为偶数
            end = ((double) sortNums[sortNums.length / 2] + (double) sortNums[(sortNums.length / 2) - 1]) / 2;
        } else {

            end = sortNums[(int) Math.ceil(sortNums.length / 2)];
        }
        return end;
    }

    private int[] paixu(int[] nums1, int[] nums2) {
        int[] sortNums = new int[nums1.length + nums2.length];
        int length1 = 0;
        int length2 = 0;
        int i = 0;


        if (nums1.length == 0) {
            return nums2;
        } else if (nums2.length == 0) {
            return nums1;
        }
        while (length1 < nums1.length && length2 < nums2.length) {
            if (nums1[length1] < nums2[length2]) {              // 第一数组的元素小
                sortNums[i] = nums1[length1];
                length1++;
            } else {
                sortNums[i] = nums2[length2];
                length2++;
            }
            i++;
        }

        if (length1 == nums1.length) {                          //数组一已经加完
            for (int j = length2; j < nums2.length; j++) {
                sortNums[length1 + j] = nums2[j];
            }


        } else if (length2 == nums2.length) {
            for (int j = length1; j < nums1.length; j++) {
                sortNums[j + length2] = nums1[j];
            }
        }
        return sortNums;
    }

}
