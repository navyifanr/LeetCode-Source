/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        // 如果左子树和右子树高度相差大于1，则非平衡二叉树
        if(Math.abs(getDepthRec(root.left)-getDepthRec(root.right))>1){
            return false;
        }
        // 递归判断左子树和右子树是否为平衡二叉树  
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    //a.若二叉树为空，深度为0;b.若二叉树不为空，深度=max(左子树深度，右子树深度)+1
    private int getDepthRec(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDepth=getDepthRec(root.left);
        int rightDepth=getDepthRec(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}