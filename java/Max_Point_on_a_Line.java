// Hashmap solution
// Start from each point , search afterward to find the point on the same line.
// Time is (n^2), space is hashmap size.

// Notice : we should make the -0.0 to 0.0 by  -0.0 + 0.0 in java! 

public class Solution {
    public int maxPoints(Point[] points) {
        int n = points.length, max = 0;
        for (int i = 0; i < n; ++i) {
            HashMap<Float, Integer> hash = new HashMap<Float, Integer>();
            int infinite = 0, same = 0, submax = 0;
            for (int j = i+1; j < n; ++j) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    same++;
                }
                else if (points[i].x == points[j].x) {
                    infinite++;
                    submax = Math.max(submax,infinite+1);
                }
                else {
                    float slope = (float)((points[i].y - points[j].y + 0.0)*1.0/(points[i].x - points[j].x) + 0.0);
                    int count = 1;
                    if (hash.containsKey(slope)) {
                        count += hash.get(slope);
                    }
                    submax = Math.max(submax,count+1);
                    hash.put(slope,count);
                }
            }
            max = Math.max(Math.max(submax,1)+same, max);
        }
        return n == 1 ? 1 : max;
    }
}
