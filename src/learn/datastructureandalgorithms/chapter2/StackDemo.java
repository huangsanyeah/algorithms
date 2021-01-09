package learn.datastructureandalgorithms.chapter2;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：左括号必须与相同类型的右括号匹配，左括号必须以正确的顺序匹配。
 * 例如，{ [ ( ) ( ) ] } 是合法的，而 { ( [ ) ] } 是非法的。
 * 解决办法：
 * 从左到右顺序遍历字符串。当出现左括号时，压栈。当出现右括号时，出栈。并且判断【当前右括号，和被出栈的左括号】是否是互相匹配的一对。
 * 如果不是，则字符串非法。当遍历完成之后，如果栈为空。则合法。如下图所示：
 */
public class StackDemo {
    public static void main(String[] args) {

        String s = "{[()()]}";
        System.out.println(isLegal(s));

    }

    private static int isLeft(char c) {
        if (c == '{' || c == '(' || c == '[') {
            return 1;
        } else {
            return 2;
        }
    }

    private static int isPair(char p, char curr) {
        if ((p == '{' && curr == '}') || (p == '[' && curr == ']') || (p == '(' && curr == ')')) {
            return 1;
        } else {
            return 0;
        }
    }

    private static String isLegal(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (isLeft(curr) == 1) {
                //是左括号，压栈
                stack.push(curr);
            } else {
                if (stack.empty()) {
                    return "非法";
                }
                //当前是右括号，那么就出栈
                char p = (char) stack.pop();
                //然后比较出栈的左括号跟右括号内容是否对应匹配
                if (isPair(p, curr) == 0) {
                    return "非法";
                }
            }
        }
        if (stack.empty()) {
            return "合法";
        } else {
            return "非法";
        }

    }

}
