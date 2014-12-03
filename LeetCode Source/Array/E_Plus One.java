/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        int one=1;
        for(int i=len-1;i>=0;i--){
            int sum=digits[i]+one;
            digits[i]=sum%10;
            one=sum/10;
        }
        if(one==1){
            int[] num=new int[len+1];
            num[0]=1;
            for(int i=0;i<len;i++){
                num[i+1]=digits[i];
            }
            return num;
        }else{
            return digits;
        }
    }
}