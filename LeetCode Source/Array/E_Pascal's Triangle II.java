/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        List<Integer> ll=null;                                    //注意初始化
        for(int i=0;i<=rowIndex;i++){
            ll=new ArrayList<Integer>();
            if(i==0){
                ll.add(1);
            }else if(i==1){
                ll.add(1);
                ll.add(1);
            }else{
                List<Integer> temp=list.get(i-1);
                ll.add(1);
                for(int j=0;j<i-1;j++){
                    ll.add(temp.get(j)+temp.get(j+1));
                }
                ll.add(1);
            }
            list.add(ll);
        }
        return ll;
    }
}