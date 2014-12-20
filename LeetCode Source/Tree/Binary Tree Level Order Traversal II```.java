/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        dfs(root,0,ret);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        //将List翻转
        for(int i=ret.size()-1;i>=0;i--){
            result.add(ret.get(i));
        }
        return result;
    }
    //分层遍历-递归
    private static void dfs(TreeNode root,int level,List<List<Integer>> ret){
        if(root==null){
            return;
        }
        //添加一个新的ArrayL表示新的一层
		if(level>=ret.size()){
			ret.add(new ArrayList<Integer>());
		}
		ret.get(level).add(root.val);  //把节点添加到表示那一层的ArrayList里
		dfs(root.left,level+1,ret);    //递归处理下一层的左子树和右子树
        dfs(root.right,level+1,ret);
    }
}

//迭代法：
public List<List<Integer>> levelOrderBottom(TreeNode root){
	List<List<Integer>> result=new ArrayList<List<Integer>>();
	if(root==null){
		return result;
	}
	Queue<TreeNode> queue=new LinkedList<TreeNode>();
	queue.add(root);

	List<List<Integer>> list=new ArrayList<List<Integer>>();
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

	//翻转list
	for(int i=list.size()-1;i>=0;i--){
		result.add(list.get(i));
	}
	return result;
}