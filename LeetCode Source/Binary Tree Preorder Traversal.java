/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
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

//1.递归
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();

        preorder(root,result);

        return result;
    }

    public void preorder(TreeNode root,ArrayList<Integer> result){
    	if(root!=null){
    		result.add(root.val);
    		preorder(root.left,result);
    		preorder(root.right,result);
    	}
    }
}

//2.非递归
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();

        if(root==null)
        	return result;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()){
        	TreeNode tn=stack.pop();
        	result.add(tn.val);

        	if(tn.right!=null){
        		stack.push(tn.right);
        	}

        	if(tn.left!=null){
        		stack.push(tn.left);
        	}
        }
        return result;
    }
}