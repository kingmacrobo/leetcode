// Firstly, put the newInterval input the interval list in order
// Secondly, pass once to generate the result list via comparing the pre and cur's start and end point.
// Time is O(n), space is O(n);

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
        List<Interval> result = new ArrayList<Interval>();
        int i = 0, size = intervals.size();
        for (; i < size; ++i) {
            if (intervals.get(i).start >= newInterval.start) {
                intervals.add(i,newInterval);
                break;
            }
        }
        if (i == size) 
            intervals.add(newInterval);
        Interval pre = null;
        for (i = 0; i < intervals.size(); ++i) {
            Interval cur = intervals.get(i);
            if (pre == null || cur.start > pre.end) {
                result.add(cur);
                pre = cur;
            }
            else {
                pre.end = Math.max(pre.end,cur.end);
            }
        }
        return result;
    }
}
