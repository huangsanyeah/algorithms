package learn.datastructureandalgorithms.chapter2;

/**
 * 字符串 s = "goodgoogle"，判断字符串 t = "google" 在 s 中是否存在
 * 完全匹配才能表明存在
 * TODO
 */
public class StringDemo {
    public static void main(String[] args) {
//        String str="12345";
//        String subStr="25";
//        System.out.println(str.contains(subStr));
        s1();
    }
    public static void s1() {

        String s = "agoodgoogle";

        String t = "google";

        int isfind = 0;

        for (int i = 0; i < s.length() - t.length() + 1; i++) {

            if (s.charAt(i) == t.charAt(0)) {

                int jc = 0;

                for (int j = 0; j < t.length(); j++) {

                    if (s.charAt(i + j) != t.charAt(j)) {

                        break;

                    }

                    jc = j;

                }

                if (jc == t.length() - 1) {

                    isfind = 1;

                }

            }

        }

        System.out.println(isfind);

    }

}
