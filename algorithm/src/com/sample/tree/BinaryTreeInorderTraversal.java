package com.sample.tree;
/*
给定一个二叉树，返回它的中序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * */
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	
	public static void main(String args[]) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.right = node2;
		node2.left = node3;
		List<Integer> list = new BinaryTreeInorderTraversal().inorderTraversal(node1);
		System.out.println(list);
	}
	
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList() ;
        List<Integer> list = new LinkedList();
        if(root == null) {
        	    return list;
        }
        stack.push(root);
        TreeNode cur = root;
        while(!stack.isEmpty()) {
        	    cur = stack.peek();
        	    while(cur.left != null) {
        	    	    cur = cur.left;
        	    	    	stack.push(cur);
        	    }
        	    cur = stack.pop();
        	    list.add(cur.val);
        	    while(cur.right == null && !stack.isEmpty()) {
        	    	    cur = stack.pop();
        	    	    list.add(cur.val);
        	    }
        	    if(cur.right != null) {
        	    	    stack.push(cur.right);
        	    }
        }
        return list;
    }
    
    static class TreeNode {
    	    int val;
    	    TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
