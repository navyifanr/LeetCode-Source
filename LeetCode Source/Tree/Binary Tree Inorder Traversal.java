/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        inorderRec(root,list);
        return list;
    }
    private void inorderRec(TreeNode root,List<Integer> list){    //注意此处运用全局的List
        if(root==null){
            return;
        }
        inorderRec(root.left,list);
        list.add(root.val);
        inorderRec(root.right,list);
    }
}

//迭代法,用栈先将根节点的所有左孩子都添加到栈内，然后再输出栈顶元素，再处理栈顶元素的右节点
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list=new ArrayList<Integer>();
    if(root==null){
        return list;
    }
    Stack<TreeNode> stack=new Stack<TreeNode>();
    TreeNode cur=root;
    
    while(true){
        while(cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
        
        if(stack.isEmpty()){
            break;
        }
        //此时已经没有左孩子了，在栈中弹出栈顶元素，并将该节点add进List
        cur=stack.pop();
        list.add(cur.val);
        cur=cur.right;  //遍历右节点
    }
    return list;
}