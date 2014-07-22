/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

//1.通用解法，适合出现k次的
//int型数据为32位，可以开一个大小为32的int型数组存储N个元素的各个二进制位的1出现的次数，然后将该次数模3，
//若为1，则说明该位为所找元素二进制的对应那位，用一个初始为零的ret与找出的位作或运算，最终得到要找的数ret

public class Solution {
    public int singleNumber(int[] A) {
        int[] bit=new int[32];
        int ret=0;
        for(int i=0;i<32;i++){
            for(int j=0;j<A.length;j++){
                bit[i]+=(A[j]>>i)&1;
            }
            ret|=(bit[i]%3)<<i;
        }
        return ret;
    }
}


//2.想法和开辟长度为32的数组差不多，用2个整数low和high来模拟3进制的，low和high对应位上的情况只能有：
//00,01,10.如果变为11则转化成00.最终输出low即可

int singleNumber(int[] A){
	int low=0,high=0;
	for(int i=0;i<A.length;i++){
		high^=(low&A[i]);
		low^=A[i];
		int tmp=(low^high);
		high&=tmp;
		low&=tmp;
	}
	return low;
}

//3.用3个int代表3个32位的数组，one表示出现1次的位，two表示出现2次的位，three表示出现3次的位
//（然后消除所有出现3次的位）

int singleNumber(int[] A){
	int one=0,two=0,three=0;
	for(int i=0;i<A.length;i++){
		two|=one&A[i];
		one^=A[i];
		three=one&two;
		one&=~three;
		two&=~three;
	}
	return one;
}