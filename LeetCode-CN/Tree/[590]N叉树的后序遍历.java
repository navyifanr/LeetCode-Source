//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


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

/**
 * 1. 递归法
 * 2. 迭代法
 */
class Solution {
    // 1. 递归法 时间复杂度 O(n) 空间复杂度 O(n)
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public void traversal(Node root, List<Integer> list) {
        if (root != null) {
            if (root.children == null || root.children.size() == 0) {
                list.add(root.val);
            } else {
                for (Node node : root.children) {
                    traversal(node, list);
                }
                list.add(root.val);
            }
        }
    }

    //2. 迭代法，时间复杂度 O(n) 空间复杂度 O(n)
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<Node>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.addFirst(node.val);
            for (Node n : node.children) {
                stack.add(n);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T2-7.8 5min
 */