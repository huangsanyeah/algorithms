package learn.datastructureandalgorithms.chapter2;


public class StringDemo {
    public static void main(String[] args) {
//        String str="12345";
//        String subStr="25";
//        System.out.println(str.contains(subStr));
        s1();
        s2();
    }

    /*
     * 字符串 s = "goodgoogle"，判断字符串 t = "google" 在 s 中是否存在
     * 完全匹配才能表明存在
     */
    private static void s1() {

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


    /**
     * 最大公共子串
     */
    private static void s2() {

        String a = "123456";

        String b = "13452439";

        String maxSubStr = "";

        int max_len = 0;

        for (int i = 0; i < a.length(); i++) {

            for (int j = 0; j < b.length(); j++){

                if (a.charAt(i) == b.charAt(j)){

                    for (int m=i, n=j; m<a.length()&&n<b.length(); m++,n++) {

                        if (a.charAt(m) != b.charAt(n)){

                            break;

                        }

                        if (max_len < m-i+1){

                            max_len = m-i+1;

         maxSubStr = a.substring(i, m+1);

                        }

                    }

                }

            }

        }

        System.out.println(maxSubStr);

    }

}
