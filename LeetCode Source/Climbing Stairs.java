/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

//error, 用数学方法

public class Solution {
    public static int climbStairs(int n) {
        int numways=1;
        int i,one=0;
        for(i=1;i<=n/2;i++){
            one=n-2*i;
            if(one>=i)
                numways+=zuhe(one+2,i);
            else
                numways+=zuhe(i+2,one);
        }
        if(n%2==0)
            numways+=1;
        else numways+=zuhe(i+2,one);
        return numways;
    }
    public static int zuhe(int n,int m){
        return njie(n)*njie(n-m)/njie(m);
    }
    public static int njie(int n){
        int mul=1;
        for(int i=1;i<=n;i++)
            mul*=i;
        return mul;
    }
}

// 用递归思想, 太慢了,时间复杂度：O(2^lgn),当n逐渐变大时，时间呈指数增长
// (n步的由n-1步走多一步和n-2步的走多2步组成)
int climbStairsRecur(int n){
	if(n==1) return 1;
	if(n==2) return 2;
	return climbStairsRecur(n-1)+climbStairsRecur(n-2);
}

// 使用动态规划法填表，时间复杂度：O(n)
int climbStairs(int n){
	int[] data=new int[n+1];
	data[0]=0;
	data[1]=1;
	if(n>=2){
		data[2]=2;
	}
	for(int i=3;i<=n;i++){
		data[i]=data[i-1]+data[i-2];
	}
	return data[n];
}

//当然也可以直接用变量存储
int climbStairs(int n){
	if(n<4) 
		return n;
	int a=2,b=3,c=5;
	for(int i=5;i<=n;i++){
		a=c;    //此处a只是作为变量
		c=b+c;
		b=a;           
	}
	return c;
}