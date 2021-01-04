package learn.datastructureandalgorithms.chapter1;

import java.util.Arrays;

/**
 * 对于输入的数组，输出与之逆序的数组。例如，输入 a=[1,2,3,4,5]，输出 [5,4,3,2,1]。
 */
public class ReverseArray {
    public static void main(String[] args) {
//        int[] arrays = {1, 2, 3, 4, 5};
//        ReverseArray.reverseArray(arrays);
        //method1
        ReverseArray.s1_1();
        //method2
        ReverseArray.s1_2();
    }

    /**
     * @auther hwy
     */
    private static void reverseArray(int[] array) {
        int[] b = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            b[i] = array[array.length - i - 1];
        }
        System.out.println(Arrays.toString(b));
    }

    /**
     * 方法1：
     * 【时间复杂度】：代码的时间复杂度就是 O(n)+O(n)，也就是 O(n)。
     * <p>
     * 【空间复杂度】：空间方面主要体现在计算过程中，对于存储资源的消耗情况。
     * 上面这段代码中，我们定义了一个新的数组 b，它与输入数组 a 的长度相等。因此，空间复杂度就是 O(n)
     */
    private static void s1_1() {

        int[] a = {1, 2, 3, 4, 5};

        int[] b = new int[5];

        for (int i = 0; i < a.length; i++) {

            b[i] = a[i];

        }

        for (int i = 0; i < a.length; i++) {

            b[a.length - i - 1] = a[i];

        }

        System.out.println(Arrays.toString(b));

    }


    /**
     * 方法2：
     * 定义了缓存变量 tmp，接着通过一个 for 循环，从 0 遍历到a 数组长度的一半（即 len(a)/2）。
     * 每次遍历执行的是什么内容？就是交换首尾对应的元素。最后打印数组 a，得到结果。
     * 【时间复杂度分析】：
     * 1个for循环，执行的次数是数组长度的一半，时间复杂度变成了 O(n/2)。
     * 根据复杂度与具体的常系数无关的性质，这段代码的时间复杂度也就是 O(n)。
     * 【空间复杂度分析】：
     * 我们定义了一个 tmp 变量，它与数组长度无关。
     * 也就是说，输入是 5 个元素的数组，需要一个 tmp 变量；
     * 输入是 50 个元素的数组，依然只需要一个 tmp 变量。
     * 因此，空间复杂度与输入数组长度无关，即 O(1)。
     */
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
