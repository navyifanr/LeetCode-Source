/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

因为矩阵的行列都是递增的，所以可以利用左下角（或右上角）来与要找的数进行对比，然后对行列的标记进行增减即可，
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=matrix[0].length;
        int r=matrix.length;
        if(l==0||r==0) return false;
        for(int i=r-1;i>=0;i--){
            for(int j=0;j<l;){
                if(matrix[i][j]>target)
                    break;
                else if(matrix[i][j]<target)
                    j++;
                else if(matrix[i][j]==target)
                    return true;
            }
        }
        return false;
    }
}