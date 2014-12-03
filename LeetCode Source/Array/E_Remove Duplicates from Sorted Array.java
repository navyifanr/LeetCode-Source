/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        int len=A.length;
        int num=0;
        if(len<2){
            return len;
        }
        for(int i=0;i<len-1;i++){
            if(A[i]!=A[i+1]){
                A[num++]=A[i];
            }
        }
        A[num++]=A[len-1];   //注意要处理最后个元素
        return num;
    }
}

public class Solution {
    public int removeDuplicates(int[] A) {
        int len=A.length;
        int num=1;
        if(len<2){
            return len;
        }
        for(int i=1;i<len;i++){
            if(A[i]!=A[i-1]){
                A[num++]=A[i];
            }
        }
        return num;
    }
}