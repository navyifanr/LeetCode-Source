/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
*/
//递归
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isMirrorRec(root.left,root.right);
    }
    
    public static boolean isMirrorRec(TreeNode r1,TreeNode r2){
        if(r1==null&&r2==null){
            return true;
        }
        if(r1==null||r2==null){
            return false;
        }
        //如果两个树都为非空树，则先比较根节点
        if(r1.val!=r2.val){
            return false;
        }
        //递归比较r1的左子树的镜像是不是r2右子树和r1右子树的镜像是不是r2左子树
        return isMirrorRec(r1.left,r2.right)&&isMirrorRec(r1.right,r2.left);
    }
}


//迭代, 用两个队列保存左右子树的节点，每次取出两个队列的队头元素进行比较（比较前要判断保证两个节点都不为空），若相等，则继续将他们的左右节点加入对应的队列（注意加入的顺序），循环加入和取出，直到队列为空。
public boolean isSymmetric(TreeNode root){
	if(root==null){
		return true;
	}
	LinkedList<TreeNode> l=new LinkedList<TreeNode>(); //此处用链表模拟队列
	LinkedList<TreeNode> r=new LinkedList<TreeNode>();

	l.add(root.left);
	r.add(root.right);

	while(!l.isEmpty()&&!r.isEmpty()){
		TreeNode tmp1=l.pop();
		TreeNode tmp2=r.pop();
		if(tmp1==null&&tmp2!=null||tmp1!=null&&tmp2==null){
			return false;
		}
		if(tmp1!=null){
			if(tmp1.val!=tmp2.val){
				return false;
			}
			l.add(tmp1.left);
			l.add(tmp1.right);
			r.add(tmp2.right);
			r.add(tmp2.left);
		}
	}
	return true;
}