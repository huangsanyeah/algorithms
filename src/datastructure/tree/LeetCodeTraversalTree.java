package datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author huangweiyue
 * @description
 * @date Created in 2021-02-24
 */
public class LeetCodeTraversalTree {
    public static void main(String[] args) {
        //复杂版
//        TreeNode left=new TreeNode(3,new TreeNode(2),new TreeNode(4));
//        TreeNode right=new TreeNode(6,new TreeNode(5),new TreeNode(11));
//        TreeNode root=new TreeNode(0,left,right);

        //简化版
        TreeNode root = new TreeNode(0, new TreeNode(1), new TreeNode(2));

        //List<Integer> list = preorderTraversal(root);
        //List<Integer> list = inorderTraversal(root);
        List<Integer> list = postorderTraversal(root);
        System.out.println(list);
    }


    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {
                res.add(cur.val); // root
                s.push(cur);
                cur = cur.left; // left
            } else {
                cur = s.pop();
                cur = cur.right; // right
            }
        }
        return res;
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left; // left
            } else {
                cur = stack.pop();
                res.add(cur.val); // root
                cur = cur.right; // right
            }
        }
        return res;
    }

    // 前序遍历顺序为：根 -> 左 -> 右
    // 后序遍历顺序为：左 -> 右 -> 根
    // 所以, 我们可以把前序遍历的稍作修改: 根 -> 右 -> 左,
    // 然后结果存放到栈里进行倒序, 之后再遍历结果栈就可以输出后序遍历了
    public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        Stack<TreeNode> resStack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {
                resStack.push(cur); // root
                s.push(cur);
                cur = cur.right; // right
            } else {
                cur = s.pop();
                cur = cur.left; // left
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!resStack.isEmpty()) {
            res.add(resStack.pop().val);
        }
        return res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


/*
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}*/
