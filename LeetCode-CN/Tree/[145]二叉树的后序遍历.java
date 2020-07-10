//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //方法 1：递归法，时间复杂度 O(n), 空降复杂度 O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public void traversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            traversal(root.left, list);
            traversal(root.right, list);
            list.add(root.val);
        }
    }

    //方法 2： 迭代法，时间复杂度 O(n)  空间复杂度 O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            result.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
