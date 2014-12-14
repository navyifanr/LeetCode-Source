/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int len=numbers.length;
        int[] results=new int[2];
        for(int i=0;i<len;i++){
            if(map.containsKey(target-numbers[i])){
                results[0]=map.get(target-numbers[i])+1;  //注意因为返回的结果下标是从1开始的，所以要加1
                results[1]=i+1;  
            }else{
                map.put(numbers[i],i);
            }
        }
        return results;
    }
}

//法2：暴力法，超时
public static int[] twoSum(int[] numbers,int target){
	int[] ret=new int[2];
	int len=numbers.length;
	for(int i=0;i<len-1;i++){
		for(int j=i+1;j<len;j++){
			if(numbers[i]+numbers[j]==target){
				ret[0]=i+1;
				ret[1]=j+1;
			}
		}
	}
	return ret;
}