//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1124 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //方法1：缺点，diameterOfBinaryTree 调用递归函数 maxDepth，而 maxDepth 是要遍历子树的所有节点的，所以最坏时间复杂度是 O(N^2)。
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        //注意，不能直接返回根节点的最长直径，也有可能出现在左子树，或右子树上
        int rootMax = leftDepth + rightDepth;
        int leftMax = diameterOfBinaryTree(root.left);
        int rightMax = diameterOfBinaryTree(root.right);
        return Math.max(rootMax, Math.max(leftMax, rightMax));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

    //方法2：优化
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int curNodeDiameter = leftDepth + rightDepth;   //注意，此处不要加1，下面 return 已经加了
        maxDiameter = Math.max(curNodeDiameter, maxDiameter);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
