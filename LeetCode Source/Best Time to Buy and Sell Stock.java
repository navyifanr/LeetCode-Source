/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

/*
要使收益最大化，则以最低价买入，最高价卖出；扫描数组，求数组中数字相差最大值的过程，但是这个最大值，永远都是后者减去前者。
先设置最大利润maxProfit = 0，初始最小值min = prices[0]，然后从第2个元素开始，扫描一遍数组，计算int tmpProfit = prices[i]-min，如果tmpProfit比maxProfit大，
就更新maxProfit值，同时比较min和prices[i]的大小关系，更新最小值。这一步用来保证买入的时候值最小，这样就能保证利润最大化。
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int maxProfit=0;
        int min=prices[0];
        int len=prices.length;
        for(int i=1;i<len;i++){
            int tmpProfit=prices[i]-min;
            if(maxProfit<tmpProfit){
                maxProfit=tmpProfit;
            }
            if(min>prices[i]){
                min=prices[i];
            }
        }
        return maxProfit;
    }
}

//更直观理解
int maxProfit(int prices[]) {
	if(prices==null||prices.length==0)
            return 0;
  	int min = 0;
  	int maxProfit = 0;
  	int len=prices.length;
  	int buy = sell = 0;
  	for (int i = 0; i < len; i++) {
    	if (prices[i] < prices[min])
      		min = i;
    	int tmp = prices[i] - prices[min];
    	if (tmp > maxProfit) {
      		buy = min;
      		sell = i;
      		maxProfit = tmp;
    	}
  	}
  	return maxProfit;
}