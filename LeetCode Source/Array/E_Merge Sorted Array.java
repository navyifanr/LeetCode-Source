/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/

public class Solution {
    public void merge(int A[], int m, int B[], int n) {           //从后往前排
        int k=m-1;
        int l=n-1;
        int i=n+m-1;
        for(i=n+m-1;i>=0&&k>=0&&l>=0;i--){
            if(A[k]>B[l]){
                A[i]=A[k];
                k--;
            }else{
                A[i]=B[l];
                l--;
            }
        }
        while(k>=0){
            A[i--]=A[k--];
        }
        while(l>=0){
            A[i--]=B[l--];
        }
    }
}