/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}

//迭代法
public int maxDepth(TreeNode root){
	if(root==null){
		return 0;
	}
	Queue<TreeNode> queue=new LinkedList<TreeNode>();
	queue.add(root);

	int depth=0;
	int currentLevelNodes=1;   //当前层，node的数量
	int nextLevelNodes=0;      //下一层，node的数量

	while(!queue.isEmpty()){
		TreeNode cur=queue.remove();   //从队头位置移除(先进来的的先被移除)
		currentLevelNodes--;           //减少当前层node的数量
		if(cur.left!=null){
			nextLevelNodes++;
			queue.add(cur.left);
		}
		if(cur.right!=null){
			nextLevelNodes++;
			queue.add(cur.right);
		}
		if(currentLevelNodes==0){    //说明已经遍历当前层的所有节点
			depth++;
			currentLevelNodes=nextLevelNodes;
			nextLevelNodes=0;
		}
	}
	return depth;
}