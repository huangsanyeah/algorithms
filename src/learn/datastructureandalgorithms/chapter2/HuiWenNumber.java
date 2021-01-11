package learn.datastructureandalgorithms.chapter2;

import java.util.Scanner;

/**
 * @author huangweiyue
 * @description 输入一个数，判断回文数
 * @date Created in 2021-01-09
 * @modifiedBy
 */
public class HuiWenNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();

        String str1 = String.valueOf(num);

        StringBuilder str2 = new StringBuilder(str1);
        str2.reverse();
        int count = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                System.out.println(str1 + "不是回文数");
                break;
            } else {
                count++;
            }
        }
        if (count == str1.length()) {
            System.out.println(str1 + "是回文数");
        }
    }
}
