/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(root==null){
            return list;
        }
        List<Integer> item=new ArrayList<Integer>();
        item.add(root.val);
        getSumRec(root,sum-root.val,item,list);
        return list;
    }

    private void getSumRec(TreeNode root,int sum,List<Integer> item,List<List<Integer>> list){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null&&sum==0){   //到达叶子节点，并且和等于目标值时，add进list
            list.add(new ArrayList<Integer>(item));
            return;
        }
        if(root.left!=null){
            item.add(root.left.val);
            getSumRec(root.left,sum-root.left.val,item,list);
            item.remove(item.size()-1);              //切换到另一条路径
        }
        if(root.right!=null){
            item.add(root.right.val);
            getSumRec(root.right,sum-root.right.val,item,list);
            item.remove(item.size()-1);
        }
    }
}







 //超时
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        List<Integer> item=new ArrayList<Integer>();
        addSum(root,sum,item,list);
        return list;
    }
    
    private int addSum(TreeNode root,int target,List<Integer> item,List<List<Integer>> list){
        if(root==null){
            return 0;
        }
        int sum=root.val;
        item.add(root.val);
        if(root.left==null&&root.right==null){
            if(sum==target){
                list.add(item); 
            }
            return sum;
        }
        if(root.left!=null){
            sum+=addSum(root.left,target,item,list);
        }
        if(root.right!=null){
            sum+=addSum(root.right,target,item,list);
        }
        return sum;
    }
}

//错误
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> nodes=new LinkedList<TreeNode>();
        Queue<Integer> values=new LinkedList<Integer>();
        
        nodes.add(root);
        values.add(root.val);
        
        List<Integer> item=new ArrayList<Integer>();
        while(!nodes.isEmpty()){
            TreeNode cur=nodes.remove();
            int sumVal=values.remove();
            item.add(cur.val);
            
            if(cur.left==null&&cur.right==null){
                if(sumVal==sum){
                    list.add(item);
                }
                item=new ArrayList<Integer>();   //会丢失掉之前的结点
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
        return list;
    }
}



