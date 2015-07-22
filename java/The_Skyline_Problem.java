// Search from left to right to find the continue growing buildings, and add the cross point to result array.
// When the building can't grow any more, we should start consider the decreasing cases.
// Time: worse is O(n^2), best is O(n), no extra space used.

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        int n = buildings.length;
        if (n == 0) return result;
        int pre = 0, start = 0;
        for (int i = 1; i <= n; ++i) {
            if (i < n && buildings[i][2] == buildings[pre][2] && buildings[i][0] == buildings[pre][1]) {
                buildings[pre][1] = buildings[i][1];
                continue;
            }
            if (i < n && buildings[i][2] > buildings[pre][2] && buildings[i][0] <= buildings[pre][1]) {
                if (buildings[i][0] > buildings[pre][0]) {
                    result.add(new int[]{buildings[pre][0],buildings[pre][2]});
                }
                pre = i;
            }
            else {
                if (i == n || buildings[i][0] > buildings[pre][1]) {
                    result.add(new int[]{buildings[pre][0], buildings[pre][2]});
                    int maxHeight = 0, loc = -1;
                    for (int j = start ; j < i; ++j) {
                        if (j == pre) continue;
                        if (buildings[pre][1] < buildings[j][1] && buildings[pre][1] >= buildings[j][0]) {
                            if (buildings[j][2] > maxHeight) {
                                maxHeight = buildings[j][2];
                                loc = j;
                            }
                        }
                    }
                    if (loc == -1) {
                        result.add(new int[]{buildings[pre][1], 0});
                        if (i == n) break;
                        start = pre = i;
                    }
                    else {
                        buildings[loc][0] = buildings[pre][1];
                        pre = loc;
                        i = i-1;
                    }
                }
            }
        }
        return result;
    }
}
