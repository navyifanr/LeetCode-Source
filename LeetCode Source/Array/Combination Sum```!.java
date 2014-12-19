/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>(); //注意多维List的初始化
        if(candidates==null||candidates.length==0){
        	return res;
        }
        Arrays.sort(candidates);
        helper(candidates,0,target,new ArrayList<Integer>(),res);
        return res;
    }

    private void helper(int[] candidates,int start,int target,ArrayList<Integer> item,List<List<Integer>> res){ //注意和前面类型对应
    	if(target<0){
    		return;
    	}
    	if(target==0){
    		res.add(new ArrayList<Integer>(item));
    		return;
    	}
    	for(int i=start;i<candidates.length;i++){
    		if(i>0&&candidates[i]==candidates[i-1]){
    			continue;
    		}
    		item.add(candidates[i]);
    		helper(candidates,i,target-candidates[i],item,res);
    		item.remove(item.size()-1);
    	}
    }
}

