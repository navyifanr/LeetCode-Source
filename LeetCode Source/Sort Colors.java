/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with an one-pass algorithm using only constant space?
*/

//最简单的方法，先统计出现0、1、2出现的次数，然后直接给数组赋值就ok了
public class Solution {
    public void sortColors(int[] A) {
        int rnum=0;
        int wnum=0;
        int bnum=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==0)
                rnum++;
            else if(A[i]==1)
                wnum++;
            else
                bnum++;
        }
        for(int i=0;i<rnum;i++)
            A[i]=0;
        for(int i=0,j=rnum;i<wnum;i++)
            A[j++]=1;
        for(int i=0,j=rnum+wnum;i<bnum;i++)
            A[j++]=2;
    }
}


//

public void sortColors(int[] A){
	int end=A.length-1;
	int start=0;
	for(int i=0;i<=end;i++){
		if(A[i]==0){
			swap(A,i,start);
			start++;
		}
		if(A[i]==2){
			swap(A,i,end);
			end--;
			i--;    //判断交换后改位的数
		}
	}
}
void swap(int[] A,int i,int j){
	int tmp=A[i];
	A[i]=A[j];
	A[j]=tmp;
}
