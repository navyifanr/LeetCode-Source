/*
Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
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
//递归解法，如果根节点相同，再递归的看左子树和右子树是否相同
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else if(p!=null&&q!=null){
            if(p.val==q.val)
                return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
            else
                return false;
        }else{
            return false;
        }
    }
}
//递归2
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p==null&&q==null){
        return true;
    }
    if(p==null&&q!=null||(p!=null&&q==null)){  //  if(p==null||q==null)
        return false;
    }
    if(p.val!=q.val){
        return false;
    }
    return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
}


// 迭代，使用栈
public boolean isSameTree(TreeNode p,TreeNode q){
    if(p==null&&q==null){
        return true;
    }
    if(p==null||q==null){
        return false;
    }

    Stack<TreeNode> s1=new Stack<TreeNode>();
    Stack<TreeNode> s2=new Stack<TreeNode>();

    s1.add(p);
    s2.add(q);

    while(!s1.isEmpty()&&!s2.isEmpty()){
        TreeNode t1=s1.pop();
        TreeNode t2=s2.pop();

        if(t1==null&&t2==null){
            continue;
        }else if(t1!=null&&t2!=null&&t1.val==t2.val){  //注意入栈顺序
            s1.push(t1.right);
            s1.push(t1.left);
            s2.push(t2.right);
            s2.push(t2.left);
        }else{
            return false;
        }
    }
    return true;
}