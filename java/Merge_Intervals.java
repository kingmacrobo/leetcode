// First Sort the list by the start point
// And then, merger the list in O(n^2), space is O(n)

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
	        List<Interval> result = new ArrayList<Interval>();
	        Comparator<Interval> com = new MyComparator();
	        Collections.sort(intervals,com);
	        boolean[] visited = new boolean[intervals.size()];
	        for (int i = 0; i < intervals.size(); ++i) visited[i] = false;
	        for (int i = 0; i < intervals.size(); ++i) {
	            if (visited[i]) continue;
	            Interval in1 = intervals.get(i);
	            for (int j = i + 1; j < intervals.size(); ++j) {
	                if (visited[j]) continue;
	                Interval in2 = intervals.get(j);
	                if (!(in1.start > in2.end || in1.end < in2.start)) {
	                    in1.start = Math.min(in1.start,in2.start);
	                    in1.end = Math.max(in1.end,in2.end);
	                    visited[j] = true;
	                }
	            }
	            result.add(in1);
	        }
	        return result;
	    }
	    class MyComparator implements Comparator<Interval> {
	        @Override
	        public int compare(Interval i1, Interval i2) {
	            if (i1.start < i2.start) return -1;
	            else if (i1.start > i2.start) return 1;
	            else return 0;
	        }
	    }
}


// Another clean solution :
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

        List<Interval> ret = new ArrayList<>();
        Interval prev = null;
        for (Interval inter : intervals) {
            if (  prev==null || inter.start>prev.end ) {
                ret.add(inter);
                prev = inter;
            } else if (inter.end>prev.end) {
                // Modify the element already in list
                prev.end = inter.end;
            }
        }
        return ret;
    }
}
