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

//利用快排partition思想，以1为枢纽元对数组进行划分，使0在数组的左边，2在数组的右边，1在数组的中间
public class Solution {
    public void sortColors(int[] A) {
        int end=A.length-1;
        int begin=0;
        for(int i=0;i<=end;i++){
            if(A[i]==0){
                swap(A,begin,i);
                begin++;
            }else if(A[i]==2){
                swap(A,end,i);
                end--;
                i--;
            }
        }
    }
    
    void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}


//另外一个通俗的方法，记录0,1,2的数目，然后对数组按顺序进行重新赋值

public class Solution {
    public void sortColors(int[] A) {
        int zero=0;
        int one=0;
        int two=0;
        int len=A.length;
        for(int i=0;i<len;i++){
            if(A[i]==0){
                zero++;
            }else if(A[i]==1){
                one++;
            }else{
                two++;
            }
        }
        for(int i=0;i<zero;i++){
            A[i]=0;
        }
        for(int j=zero;j<zero+one;j++){
            A[j]=1;
        }
        for(int k=zero+one;k<len;k++){
            A[k]=2;
        }
    }
}