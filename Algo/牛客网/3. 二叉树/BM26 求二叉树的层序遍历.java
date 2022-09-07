/*
描述
给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
例如：
给定的二叉树是{3,9,20,#,#,15,7},

该二叉树层序遍历的结果是
[
[3],
[9,20],
[15,7]

]


数据范围：二叉树的节点数满足 1 \le n \le 10^5 \1≤n≤10 
5
  


示例1
输入：
{1,2}

返回值：
[[1],[2]]

示例2
输入：
{1,2,3,4,#,#,5}

返回值：
[[1],[2,3],[4,5]]
*/

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    /**
     *  迭代法：
     * @param root TreeNode类 
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            int levelSize = nodes.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodes.poll();
                list.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    //方法2：递归法
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        if (root == null) return res;
        preorder(root, 0);
        return res;
    }
    
    public void preorder(TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() <= depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        preorder(root.left, depth + 1);
        preorder(root.right, depth + 1);
    }

}