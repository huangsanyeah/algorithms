package learn.datastructureandalgorithms.chapter1;

/**
 * @author huangweiyue
 * @description 数组中查找出现次数最多的那个数字
 * O(n²)
 * @date Created in 2021-01-05
 */
public class FindMaxCountFromArray {
    public static void main(String[] args) {
        s1_4();
    }

    public static void s1_4() {

        int a[] = {1, 3, 4, 3, 4, 1, 3};

        int val_max = -1;

        int time_max = 0;

        int time_tmp;

        for (int i = 0; i < a.length; i++) {

            time_tmp = 0;

            for (int j = 0; j < a.length; j++) {

                if (a[i] == a[j]) {

                    time_tmp += 1;

                }

                if (time_tmp > time_max) {

                    time_max = time_tmp;

                    val_max = a[i];

                }

            }

        }

        System.out.println(val_max);

    }
}
