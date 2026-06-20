import java.util.Arrays;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        int[][] reqs = new int[m + 1][2];
        for (int i = 0; i < m; i++) {
            reqs[i] = restrictions[i];
        }
        reqs[m] = new int[]{1, 0};
        
        Arrays.sort(reqs, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 1. Left-to-Right Pass: Propagate constraints from left to right
        for (int i = 1; i <= m; i++) {
            int dist = reqs[i][0] - reqs[i - 1][0];
            reqs[i][1] = Math.min(reqs[i][1], reqs[i - 1][1] + dist);
        }
        
        // 2. Right-to-Left Pass: Propagate constraints from right to left
        for (int i = m - 1; i >= 0; i--) {
            int dist = reqs[i + 1][0] - reqs[i][0];
            reqs[i][1] = Math.min(reqs[i][1], reqs[i + 1][1] + dist);
        }
        
        // 3. Find the maximum height between each pair of restrictions
        int maxH = 0;
        for (int i = 1; i <= m; i++) {
            int dist = reqs[i][0] - reqs[i - 1][0];
            int h1 = reqs[i - 1][1];
            int h2 = reqs[i][1];
            
            // Formula to find the peak height between two buildings
            int peak = h1 + (dist + h2 - h1) / 2;
            maxH = Math.max(maxH, peak);
        }
        
        // 4. Consider the remaining buildings from the last restriction up to n
        int lastIdx = reqs[m][0];
        int lastH = reqs[m][1];
        maxH = Math.max(maxH, lastH + (n - lastIdx));
        
        return maxH;
    }
}