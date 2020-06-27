//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    // 迭代法 时间复杂度 O(n)  空间复杂度 O(n)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                queue.addAll(node.children);
            }
            result.add(list);
        }
        return result;
    }

    //递归法  时间复杂度 O(n) 空间复杂度 O(log n)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        traveral(root, 0, result);
        return result;
    }

    public void traveral(Node root, int level, List<List<Integer>> list) {
        if (root != null) {
            if (list.size() <= level) {
                list.add(new ArrayList<>());
            }
            list.get(level).add(root.val);
            for (Node node : root.children) {
                traveral(node, level + 1, list);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
