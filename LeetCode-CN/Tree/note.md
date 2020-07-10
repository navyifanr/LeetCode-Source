##二叉树遍历

树的遍历-迭代法：
1. 前序、中序、后序遍历都是用栈存储 LinkedList--> stack.pollLast()，注意点：
前序遍历：先存右节点，再存左节点
```
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();  //<-- PS 
            result.add(node.val);
            if (node.right != null) {          //先 add 右节点
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return result;
    }
```
中序遍历：while 判断加当前节点，一直向下寻找左节点
```
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {     //循环向下寻找左节点
                stack.add(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pollLast();   //<-- PS
            result.add(curNode.val);
            curNode = curNode.right;
        }
        return result;
    }
```
后序遍历：添加遍历后的结果，要添加到队列头部
```
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();  //<-- PS
            result.addFirst(node.val);         // 使用 addFirst
            if (node.left != null) {           //先遍历 左节点
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return result;
    }
```


2. 层次遍历使用队列存储 LinkedList--> queue.poll() / queue.pollFirst()

```
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();      // 取队首
                list.add(node.val);
                if (node.left != null) {           //按左右顺序添加
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
```