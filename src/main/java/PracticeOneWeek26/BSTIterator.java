package PracticeOneWeek26;

import java.util.*;
public class BSTIterator {
    public Stack<TreeNode> stack = new Stack<TreeNode>();
    
    //@param root: The root of binary tree.
    //Add till end of left
    public BSTIterator(TreeNode root) {
        if (root == null) {
            return;
        }
        stack.push(root);
        while (root.left != null) {
            stack.push(root.left);
            root = root.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return stack.size() > 0;
    }
    
    //@return: return next node
    public TreeNode next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            TreeNode temp = node.right;
            stack.push(temp);
            while (temp.left != null) {
                stack.push(temp.left);
                temp = temp.left;
            }            
        }
        return node;
    }
    private class TreeNode{
        TreeNode left;
        TreeNode right;
    }
}