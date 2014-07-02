/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/


//常规解法：先对数组进行排序，然后通过按顺序判断每相邻两个数是否相同即可
public class Solution {
    public int singleNumber(int[] A) {
        Arrays.sort(A);
        for(int i=0;i<=A.length-1;){   //注意数组只有一个的情况
            if((i+1)<=A.length-1){     //判断A[i]是否是最后一个
                if(A[i]!=A[i+1])
                    return A[i];
                else i+=2;
            }else{
                return A[i];
            }
        }
        return -1;
    }
}

//位运算解法：使用异或运算 这个程序用了个小技巧：一个整数和它本身异或之后得到值是0，0与其他整数异或得到的是这个整数本身

public int singleNumber(int[] A){
	if(A.length==0)
		return -1;
	int result=0;
	for(int i=0;i<A.length;i++){
		result^=A[i];
	}
	return result;
}