/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/


/*
先对间隔段按起点由小到大排序（起点相同按终点排），那么问题来了，如何对对象进行排序？
Java可以通过集合自带的排序和比较器实现，即java.util.Collections.sort(List, Comparator)；
排序后，先将第一个间隔段存入的合并后的List，取合并后的List的最后一个间隔段的终点和intervals的第一个的起点比较，判断是否合并，合并就修改List的最后间隔段的终点，不合并就直接add进List, 循环遍历intervals即可
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list=new ArrayList<Interval>();
        if(intervals==null||intervals.size()==0){  //注意先要判断intervals是否为空，或长度为0
        	return intervals;                      //注意是返回intervals,而不是直接null，若[],应返回[]
        }
        Comparator<Interval> comp=new Comparator<Interval>(){
        	@Override
        	public int compare(Interval i1,Interval i2){
        		if(i1.start==i2.start){
        			return i1.end-i2.end;
        		}
        		return i1.start-i2.start;
        	}
        };

        Collections.sort(intervals,comp);

        list.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
        	if(list.get(list.size()-1).end>=intervals.get(i).start){
        		list.get(list.size()-1).end=Math.max(list.get(list.size()-1).end,intervals.get(i).end); //注意这里要比较两个end点的大小
        	}else{
        		list.add(intervals.get(i));
        	}
        }
        return list;
    }
}