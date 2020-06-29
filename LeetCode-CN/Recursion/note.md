递归&&分治

递归代码模板

```$java
public void recur(int level, int param) { 
  //1. terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  //2. process current logic 
  process(level, param); 
  //3. drill down 
  recur( level: level + 1, newParam); 
  //4. restore current status 
}
```

递归思维要点
1. 不要人肉进行递归(最大误区)
2. 找到最近最简方法，将其拆解成可重复解决的问题(重复子问题) 
3. 数学归纳法思维

分治代码模板

```$java
# Python
def divide_conquer(problem, param1, param2, ...): 
  #1. recursion terminator 
  if problem is None: 
	print_result 
	return 
  #2. prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 
  #3. conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …
  #4. process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  #5. revert the current level states
```