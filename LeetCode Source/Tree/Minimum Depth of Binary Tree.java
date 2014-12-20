/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
//递归
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        //注意当某节点没有左或右节点时，不能取它左右子树中小的作为深度，因为那样会是0， （加1是父节点）
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
//迭代
public int minDepth(TreeNode root){
	if(root==null){
		return 0;
	}
	Queue<TreeNode> queue=new LinkedList<TreeNode>();
	Queue<Integer> counts=new LinkedList<Integer>();

	queue.add(root);
	counts.add(1);

	while(!queue.isEmpty()){
		TreeNode cur=queue.remove();
		int count=counts.remove();

		if(cur.left!=null){
			queue.add(cur.left);
			counts.add(count+1);
		}

		if(cur.right!=null){
			queue.add(cur.right);
			counts.add(count+1);
		}

		if(cur.left==null&&cur.right==null){  //遇到叶子节点就返回结果
			return count;
		}
	}
	return 0;
}