/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        return sum(root,0);
    }
    
    public int sum(TreeNode node,int parentVal){
        int sum=0;
        int temp=parentVal*10+node.val;
        if(node.left==null&&node.right==null){
            sum=temp;
        }
        if(node.left!=null){
            sum+=sum(node.left,temp);
        }
        if(node.right!=null){
            sum+=sum(node.right,temp);
        }
        return sum;
    }
} 