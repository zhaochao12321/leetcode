package zhaoTest;

/**
 * Created by zhaochao on 2019/7/25.
 */

public class SumToTarget {

    public static void main(String[] args) {
        SumToTarget sumToTarget = new SumToTarget();
        int target = (int) (Math.random() * 50 + 50);
//        int target = 200;

        int[] ints = sumToTarget.fetchStrings((int) (Math.random() * 10 + 10));
        System.out.println("目标数" + target);
        System.out.print("数组");
        for (int aa : ints) {
            System.out.print(aa + "  ");
        }
        System.out.println("");
        System.out.println("找到的数组：");
        int[] threeNumber = sumToTarget.threeNumberToTarget(ints, target);
        for (int num : threeNumber) {
            System.out.print(num + "   ");
        }
        System.out.println();
        System.out.println("end");
    }

    private int[] fetchStrings(int length) {
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = (int) (Math.random() * 50);
        }
        return ints;
    }

    private int[] threeNumberToTarget(int[] numbers, int target) {
        int[] threeNumber = new int[3];
        flag:
        for (int i = 0; ; i++) {
            for (int j = 0; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    for (int m = k + 1; m < numbers.length; m++) {
                        if ((numbers[j] + numbers[k] + numbers[m]) == target + i || (numbers[j] + numbers[k] + numbers[m]) == target - i) {
                            threeNumber[0] = numbers[j];
                            threeNumber[1] = numbers[k];
                            threeNumber[2] = numbers[m];
                            break flag;
                        }
                    }
                }
            }
        }
        return threeNumber;
    }

}
