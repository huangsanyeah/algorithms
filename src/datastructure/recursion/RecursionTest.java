package datastructure.recursion;

import java.math.BigInteger;

/**
 * @author huangweiyue
 * @description 阶乘 递归
 * 当程序执行到一个方法，都会开辟出一个独立的栈空间，每个空间的局部变量是独立的
 * 递归需要遵守的重要规则
 * <p>
 * 1.执行一个方法时，就创建一个新的受保护的独立空间(栈空间)
 * 2.方法的局部变量是独立的，不会相互影响, 比如n变量
 * 3.如果方法中使用的是引用类型变量(比如数组)，就会共享该引用类型的数据.
 * 4.【递归必须向退出递归的条件逼近】，否则就是无限递归,出现StackOverflowError，死龟了:)
 * 5.当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕。
 * @date Created in 2021-02-14
 */
public class RecursionTest {
    public static void main(String[] args) {
        //1.通过打印问题，回顾递归调用机制
        //注意输出的结果，是2,3,4 实际上递归时，4被最先压入栈，紧接着3,2  出栈的时候2最先出，然后3,4依次
        test(4);

        //2.阶乘 FIXME 不管是int 还是long 会存在阶乘溢出的情况 所以可以更改方法为BigInteger
        long res = factorial(5);
        System.out.println("res=" + res);

        //3.使用BigInteger实现阶乘
        int a = 5;
        BigInteger s = fac(new BigInteger(Integer.toString(a)));
        System.out.println(s);
        System.out.println(s.toString());
        System.out.println(s.toString().length());
    }

    //打印问题.
    private static void test(int n) {
        if (n > 2) {
            //如果要改为n+1 就违背了递归必须向退出递归的条件逼近这一原则，无限循环抛出异常
            test(n - 1);
        } //else {
        System.out.println("n=" + n);
        // }
    }

    //阶乘问题
    private static long factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            long result = factorial(n - 1) * n; // 1 * 2 * 3
            if (result >= Long.MAX_VALUE) {
                System.out.println("int值越界");
            } else {
                System.out.println("int值在界内");
            }
            return result;
        }
    }

    /**
     * 大数实现阶乘 防止越界
     *
     * @param num
     */
    private static BigInteger fac(BigInteger num) {
        if (num.compareTo(BigInteger.ONE) == 0) {
            return BigInteger.ONE;
        } else {
            return num.multiply(fac(num.subtract(BigInteger.ONE)));
        }
    }

}
