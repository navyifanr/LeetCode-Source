/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null&&sum-root.val==0){  //注意要同时有根节点到叶节点的路径，只有根节点是不符合要求的
            return true;
        }
        boolean bl=false;
        boolean br=false;
        if(root.left!=null){
            bl=hasPathSum(root.left,sum-root.val);
        }
        if(root.right!=null){
            br=hasPathSum(root.right,sum-root.val);
        }
        return bl||br;
    }
}
//迭代法：bfs问题，运用两个队列分别存节点值和节点的和，当当前节点的左右节点都为空，并且和等于给定值时，返回true
public boolean hasPathSum(TreeNode root,int sum){
    if(root==null){
      return false;
    }
    Queue<TreeNode> nodes=new LinkedList<TreeNode>();
    Queue<Integer> values=new LinkedList<Integer>();

    nodes.add(root);
    values.add(root.val);

    while(!nodes.isEmpty()){
      TreeNode cur=nodes.poll();
      int sumVal=values.poll();

      if(cur.left==null&&cur.right==null&&sumVal==sum){
        return true;
      }

      if(cur.left!=null){
        nodes.add(cur.left);
        values.add(sumVal+cur.left.val);
      }

      if(cur.right!=null){
        nodes.add(cur.right);
        values.add(sumVal+cur.right.val);
      }
    }
    return false;
}