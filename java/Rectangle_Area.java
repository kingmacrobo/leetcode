// Math
// We can calculate the xGap and yGap between the two rectangle:
// yGap = Math.min(H,D) < Math.max(B,F) ? 0 : Math.min(H,D) - Math.max(B,F);
// xGap = Math.min(G,C) < Math.max(E,A) ? 0 : Math.min(G,C) - Math.max(E,A);
// So, the cross area is xGap*yGap.
// Time and space is both O(1).

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C-A)*(D-B) + (G-E)*(H-F) - 
               (Math.min(H,D) < Math.max(B,F) ? 0 : Math.min(H,D) - Math.max(B,F))*
               (Math.min(G,C) < Math.max(E,A) ? 0 : Math.min(G,C) - Math.max(E,A));
    }
}
