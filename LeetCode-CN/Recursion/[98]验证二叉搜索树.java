//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root, null, null);
    }

    public boolean check(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        //判断到无效，立即 return
        if (lower != null && lower >= val) return false;
        if (upper != null && upper <= val) return false;
        if (!check(root.left, lower, val)) return false;
        if (!check(root.right, val, upper)) return false;
        return true;
    }

    //注意，必须是左子树所有节点小于当前节点，右子树所有节点大于当前节点
    //error
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        boolean isValidLeft = true;
//        if (root.left != null) {
//            isValidLeft = root.left.val < root.val && isValidBST(root.left);
//        }
//        boolean isValidRight = true;
//        if (root.right != null) {
//            isValidRight = root.right.val > root.val && isValidBST(root.right);
//        }
//        return isValidLeft && isValidRight;
//    }

    // error
    //    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
//        stack.add(root);
//        while (!stack.isEmpty()) {
//            TreeNode curNode = stack.poll();
//            if (curNode.left != null) {
//                if (curNode.left.val < curNode.val) {
//                    stack.add(curNode.left);
//                } else {
//                    return false;
//                }
//            }
//            if (curNode.right != null) {
//                if (curNode.right.val > curNode.val) {
//                    stack.add(curNode.right);
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
