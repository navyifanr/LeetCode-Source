/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        dfs(root,0,ret);
        return ret;
    }
    //分层遍历-递归
    private static void dfs(TreeNode root,int level,List<List<Integer>> ret){
        if(root==null){
            return;
        }
        if(level>=ret.size()){
            ret.add(new ArrayList<Integer>());
        }
        ret.get(level).add(root.val);
        dfs(root.left,level+1,ret);
        dfs(root.right,level+1,ret);
    }
}
//
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list=new ArrayList<List<Integer>>();
	if(root==null){
		return list;
	}
	Queue<TreeNode> queue=new LinkedList<TreeNode>();
	queue.add(root);

	List<Integer> item=new ArrayList<Integer>();

	int currentLevel=1;
	int nextLevel=0;

	while(!queue.isEmpty()){
		TreeNode cur=queue.remove();
		currentLevel--;
		item.add(cur.val);

		if(cur.left!=null){
			queue.add(cur.left);
			nextLevel++;
		}
		if(cur.right!=null){
			queue.add(cur.right);
			nextLevel++;
		}

		if(currentLevel==0){
			list.add(item);
			item=new ArrayList<Integer>();
			currentLevel=nextLevel;
			nextLevel=0;
		}
	}
	return list;
}