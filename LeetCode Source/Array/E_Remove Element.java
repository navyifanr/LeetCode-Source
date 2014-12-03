/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/
public class Solution {
    public int removeElement(int[] A, int elem) {
        int len=A.length;
        for(int i=0;i<len;i++){
            if(A[i]==elem){
                for(int j=i;j<len-1;j++){
                    int temp=A[j];
                    A[j]=A[j+1];
                    A[j+1]=temp;
                }
                len--;
                i--;    //注：重新赋值后要再判断一次
            }
        }
        return len;
    }
}


//解法二：双指针

public class Solution {
    public int removeElement(int[] A, int elem) {
        int len=A.length;
        int num=0;
        for(int i=0;i<len;i++){
            if(A[i]!=elem){
                A[num++]=A[i];
            }
        }
        return num;
    }
}