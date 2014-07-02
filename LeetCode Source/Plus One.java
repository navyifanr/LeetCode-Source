/*
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.


*/

//wrong answer

public class Solution {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        boolean flag=true;
        if(digits[len-1]!=9){
            digits[len-1]+=1;
            return digits;
        }else{
            digits[len-1]=0;                    //注意置为0
            for(int i=len-2;i>=0;i--){
                if(flag) 
                    digits[i]=(digits[i]+1)%10;
                if(digits[i]==0)                // 若该位本身就为0的情况，就会出错了
                    flag=true;
                else 
                    flag=false;
            }
        } 
        if(flag){
            int[] temp=new int[len+1];
            temp[0]=1;
            for(int i=0;i<len;i++)
                temp[i+1]=digits[i];
            return temp;
        }else{
            return digits;
        }
    }
}

/*
本题考察进位问题，注意当位数只有一位并且为9的情况。用do-while语句，逆序循环检查当前位是否是9，是9的话，并判断是否为第一位，若是第一位，
则将数组增长一位，第零位置为1，并拷贝原数组，若不为第一位则该位置0并将下标减一；不为9的话，直接加1，跳出循环
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        int index=len-1;
        do{
            if(digits[index]==9){
                if(index!=0){
                    digits[index]=0;
                    index--;
                }else{
                    digits[index]=0;        
                    int[] tmp=new int[len+1];
                    tmp[0]=1;
                    for(int i=0;i<len;i++)
                        tmp[i+1]=digits[i];
                    return tmp;
                }
            }else{
                digits[index]+=1;
                break;
            }
        }while(true);
        return digits;
    }
}