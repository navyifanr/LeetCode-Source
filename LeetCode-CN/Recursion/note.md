## 递归&&分治&&回溯

### 递归
> 递归的基本思想是某个函数直接或者间接地调用自身，这样就把原问题的求解转换为许多性质相同但是规模更小的子问题。
> 递归和枚举的区别在于：枚举是横向地把问题划分，然后依次求解子问题，而递归是把问题逐级分解，是纵向的拆分。

代码模板
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

### 分治

分治是一种典型的递归结构，分治思想流程是：分解 -> 解决 -> 合并
> 分解原问题为结构相同的子问题。
分解到某个容易求解的边界之后，进行第归求解。
将子问题的解合并成原问题的解。

代码模板
```Python
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

### 回溯

> 回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问
题的答案。回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况:

- 找到一个可能存在的正确的答案;
- 在尝试了所有可能的分步方法后宣告该问题没有答案。

回溯代码模板
```text
result = []
void backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        //做选择
        路径.add(选择)
        backtrack(路径, 选择列表)
        //撤销选择
        路径.remove(选择)
```
其中，路径是已经做出的选择；选择列表，是当前可以做的选择的所有选项；结束条件，也就是已满足选择的条件。**核心在于 for 循环里面的递归，在递归调用之前「做选择」，在递归调用之后「撤销选择」**

回溯算法属于暴利穷举，复杂度一般都较高，不像动态规划可以优化重复子问题。