package learn.datastructureandalgorithms.chapter1;

/**
 * @author huangweiyue
 * @description 查找数组中最大的值  时间复杂度为 O(n)
 * @date Created in 2021-01-05

 */
public class FindMaxValueFromArray {
    public static void main(String[] args) {
        s1();
    }


    private static void s1() {

        int a[] = {1, 4, 3};

        int max_val = -1;

        for (int i = 0; i < a.length; i++) {

            if (a[i] > max_val) {

                max_val = a[i];

            }
        }
        System.out.println(max_val);

    }
}
