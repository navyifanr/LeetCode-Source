/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();  //注意初始化，List是接口
        List<Integer> ll;
        for(int i=1;i<=numRows;i++){          //i从1开始
            ll=new ArrayList<Integer>();
            if(i==1){
                ll.add(1);
            }else if(i==2){
                ll.add(1);
                ll.add(1);
            }else{
                ll.add(1);
                List<Integer> temp=list.get(i-2);  //注意List的下标是从0开始的
                for(int j=0;j<i-2;j++){
                    ll.add(temp.get(j)+temp.get(j+1));
                }
                ll.add(1);
            }
            list.add(ll);
        }
        return list;
    }
}