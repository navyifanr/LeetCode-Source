/*
描述
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

数据范围：二叉树的节点数量满足 0 \le n \le 100 \0≤n≤100  ，二叉树节点的值满足 1 \le val \le 100 \1≤val≤100  ，树的各节点的值各不相同
示例 1：


示例1
输入：
{1,#,2,3}
复制
返回值：
[1,2,3]
*/

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @return int整型一维数组
     */
    public int[] preorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = preorder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
        return res;
    }
}