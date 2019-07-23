package zhaoTest;


/**
 * Created by zhaochao on 2019/7/23.
 * 题目大意：
 * 两个排序数组，找这两个排序数组的中位数，时间复杂度为O(log(m+n))
 * <p>
 * 验证准确性,数组长度,数组内容均为随机生成
 */

public class FindMedianSorted {
    public static void main(String[] args) throws Exception {
        FindMedianSorted findMedianSorted = new FindMedianSorted();

        int arraysLength1 = (int) (Math.random() * 20) + 1;
        int arraysLength2 = (int) (Math.random() * 20) + 1;
        int[] shuzu1 = findMedianSorted.fetchSortedArrays(arraysLength1);
        int[] shuzu2 = findMedianSorted.fetchSortedArrays(arraysLength2);


        int median = findMedianSorted.fetchMedian(shuzu1, shuzu2);
        System.out.println("中位数是 ：" + median);
    }


    /**
     * 获取随机数组
     *
     * @param arraysLength
     * @return
     */
    private int[] fetchSortedArrays(int arraysLength) {

        int[] shuzu = new int[arraysLength];

        for (int i = 0; i < arraysLength; i++) {
            shuzu[i] = (int) (Math.random() * 100);
        }

        return arraysSorted(shuzu);
    }

    /**
     * 数组排序
     *
     * @param shuzu
     * @return
     */
    private int[] arraysSorted(int[] shuzu) {
        int median;
        for (int i = shuzu.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (shuzu[j] < shuzu[j + 1]) {
                    median = shuzu[j];
                    shuzu[j] = shuzu[j + 1];
                    shuzu[j + 1] = median;
                }

            }
        }
        System.out.println("数组长度    " + shuzu.length);
        for (int i = 0; i < shuzu.length; i++) {
            System.out.print(shuzu[i] + "  ");
        }
        System.out.println();
        return shuzu;
    }


    private int fetchMedian(int[] a, int[] b) throws Exception {
        verify(a);
        verify(b);
        int mdianLocation = (int) Math.ceil((a.length + b.length) / 2) + 1;
        int pointer1 = 0;
        int pointer2 = 0;
        int end = 0;

        //  比头节点谁的大,直接已坐标
        for (int i = 0; i < mdianLocation; i++) {
            if (pointer1 < a.length && pointer2 < b.length) {
                if (i == mdianLocation - 1) {
                    end = Math.max(a[pointer1], b[pointer2]);
                }
                if (a[pointer1] > b[pointer2]) {
                    pointer1++;
                    continue;
                }
                pointer2++;
                continue;

            }
            // 某个数组移完了,另一个直接取值
            if (pointer1 < a.length) {

                end = a[pointer1 + mdianLocation - i - 1];
                break;
            }
            if (pointer2 < b.length) {

                end = b[pointer2 + mdianLocation - i - 1];
                break;
            }

        }

        return end;
    }

    /**
     * 合法性校验
     *
     * @param verifyArray
     * @throws Exception
     */

    private void verify(int[] verifyArray) throws Exception {
        if (verifyArray == null || verifyArray.length == 0) {

            throw new Exception("抛出异常");

        }


    }

}
