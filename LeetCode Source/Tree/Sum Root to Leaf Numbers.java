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

 //错误
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        return sum(root,0);
    }
    
    private int sum(TreeNode root,int parentVal){
        if(root==null){
            return 0;
        }
        int tempSum=10*parentVal+root.val;
        int sum=0;
        sum+=tempSum;
        sum+=sum(root.left,tempSum);
        sum+=sum(root.right,tempSum);
        if(root.left==null&&root.right==null){
            return sum;
        }
        return 0;
    }
}


public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        return sum(root,0);
    }
    
    private int sum(TreeNode root,int parentVal){
        if(root==null){
            return 0;
        }
        int sum=0;
        int temp=10*parentVal+root.val;
        if(root.left==null&&root.right==null){  //注意只有当节点为叶子节点时，才赋值给sum
            sum=temp;
        }
        if(root.left!=null){
            sum+=sum(root.left,temp);
        }
        if(root.right!=null){
            sum+=sum(root.right,temp);
        }
        return sum;
    }
}