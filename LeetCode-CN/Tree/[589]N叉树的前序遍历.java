//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
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

class Solution {
    //1. 递归法 时间复杂度 O(n) 控件复杂度 O(n)
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public void traversal(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            for (Node n : root.children) {
                traversal(n, list);
            }
        }
    }

    //2. 迭代法 时间复杂度 O(n)  空间复杂度 O(n)
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<Node>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
