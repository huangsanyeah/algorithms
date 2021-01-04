package learn.datastructureandalgorithms.chapter1;

import java.util.Arrays;

/**
 * 对于输入的数组，输出与之逆序的数组。例如，输入 a=[1,2,3,4,5]，输出 [5,4,3,2,1]。
 */
public class ReverseArray {
    public static void main(String[] args) {
        ReverseArray.s1_1();
    }

    private static void s1_1() {

        int[] a = {1, 2, 3, 4, 5};

        int[] b= new int[5];

        for (int i = 0; i < a.length; i++) {

            b[i] = a[i];

        }

        for (int i = 0; i < a.length; i++) {

            b[a.length - i - 1] = a[i];

        }

        System.out.println(Arrays.toString(b));

    }


    public static void s1_2() {

        int[] a = {1, 2, 3, 4, 5};

        int tmp = 0;

        for (int i = 0; i < (a.length / 2); i++) {

            tmp = a[i];

            a[i] = a[a.length - i - 1];

            a[a.length - i - 1] = tmp;

        }

        System.out.println(Arrays.toString(a));

    }

}
