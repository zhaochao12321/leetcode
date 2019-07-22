package zhaoTest;

public class TwoSum {


    public static void main(String[] args) {
        int[] aa = {3, 56, 8, 0, 65, 34, 1, 345, 67};
        TwoSum twoSum = new TwoSum();
        twoSum.paixu(aa);

    }

    /*
     * 冒泡排序
     *
     *
     * */
    public int[] paixu(int[] mm) {

        int zhongjianliang;

        for (int i = mm.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (mm[j] > mm[j + 1]) {
                    zhongjianliang = mm[j];
                    mm[j] = mm[j + 1];
                    mm[j + 1] = zhongjianliang;
                }
            }
        }

        return mm;
//        for (int nm:mm
//             ) {
//
//            System.out.print(nm+"    ");
//
//        }
    }
}
