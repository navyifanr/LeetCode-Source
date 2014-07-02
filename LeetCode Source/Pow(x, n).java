/*
Implement pow(x, n).
*/

//递归法（"折半"递归，不要用常规的一个个乘，效率很低）
public class Solution {
    public double pow(double x, int n) {
        if(n==0)
            return 1;
        if(n==1)
            return x;
        if(n==-1)
            return 1/x;
      /*  if(n%2==0){
            double tmp=pow(x,n>>1);     //减少子递归
            return tmp*tmp;
        }else{
            return pow(x,n-1)*x;
        }*/
        double tmp=pow(x,n>>1);  
        if(n%2==0){
            return tmp*tmp;
        }else{
            return tmp*tmp*x;
        }
    }
}

//DP法：


double pow(double x,int n){
	boolean isPositive=false;
	if(n==0)
		return 1;
	else if(n<0){
		isPositive=true;
		n*=-1;
	}
	double[] result=new double[n+1];
	result[1]=x;
	for(int i=2;i<=n;i++){
		if(i%2==0){
			result[i]=result[i/2]*result[i/2];
		}else{
			result[i]=result[i-1]*x;
		}
	}
	if(isPositive)
		return 1/result[n];
	else
		return result[n];
}