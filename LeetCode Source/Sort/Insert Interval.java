/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/

//直接先将要插入的节点add进去，再排序，再合并

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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals==null||intervals.size()==0){
            intervals.add(newInterval);             //注意
            return intervals;
        }
        List<Interval> list=new ArrayList<Interval>();
        intervals.add(newInterval);
        Comparator<Interval> comp=new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2){
                if(i1.start==i2.start){
                    return i1.end-i2.end;
                }
                return i1.start-i2.start;
            }
        };
        Collections.sort(intervals,comp);
        list.add(intervals.get(0));
        for(int i=1,len=intervals.size();i<len;i++){
            if(list.get(list.size()-1).end<intervals.get(i).start){
                list.add(intervals.get(i));
            }else{
                list.get(list.size()-1).end=Math.max(intervals.get(i).end,list.get(list.size()-1).end);
            }
        }
        return list;
    }
}