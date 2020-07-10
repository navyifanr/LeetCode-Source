# 广度优先搜索&&深度优先搜索
-----------

广度优先搜索 BFS

代码模板：
```
//1. 如果不需要确定当前遍历到了哪一层，BFS模板
while queue 不空：
    cur = queue.pop()
    for 节点 in cur的所有相邻节点：
        if 该节点有效且未访问过：
            queue.push(该节点)
//2. 如果要确定当前遍历到了哪一层，BFS模板
level = 0
while queue 不空：
    size = queue.size()
    while (size --) {
        cur = queue.pop()
        for 节点 in cur的所有相邻节点：
            if 该节点有效且未被访问过：
                queue.push(该节点)
    }
    level ++;
```

深度优先搜索 DFS

代码模板：
```
//递归
visited = set()
def dfs(node, visited):
    if node in visited: # terminator
    	# already visited
    	return
	visited.add(node)
	# process current node here.
	...
	for next_node in node.children():
		if next_node not in visited:
			dfs(next_node, visited)

//非递归
def DFS(self, tree):
	if tree.root is None:
		return []
	visited, stack = [], [tree.root]
	while stack:
		node = stack.pop()
		visited.add(node)
		process (node)
		nodes = generate_related_nodes(node)
		stack.push(nodes)
	# other processing work
	...
```
