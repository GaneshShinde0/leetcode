class Solution {
    public int maxPointsInitial(int[][] points) {
        HashMap<String,Set<String>> slopeToPoints = new HashMap<>();
        int n = points.length;
        int res = 1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                double slopeDouble = 0;
                if(points[i][0]==points[j][0]) slopeDouble = Double.MAX_VALUE;
                else slopeDouble = (points[i][1]-points[j][1])*1.0/(points[i][0]-points[j][0]);
                if(slopeDouble==-0.0)slopeDouble = 0;
                String slope = Arrays.toString(points[i])+","+slopeDouble;
                slopeToPoints.computeIfAbsent(slope, k->new HashSet<>()).add(points[i][0] + "," + points[i][1]);;
                slopeToPoints.get(slope).add(points[j][0]+","+points[j][1]);
                // System.out.println("Slope: +"+slope+", Points: "+slopeToPoints.get(slope));
                res = Math.max(slopeToPoints.get(slope).size(),res);
            }
        }
        return res;
    }
public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int res = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int dup = 1;  // count of duplicates
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if (dx == 0 && dy == 0) {
                    dup++;
                    continue;
                }
                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;
                // Normalize direction (avoid -0/-0 inconsistencies)
                if (dx < 0) { dx = -dx; dy = -dy; }
                else if (dx == 0) dy = Math.abs(dy);
                
                String key = dy + "/" + dx;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            res = Math.max(res, dup);
            for (int cnt : map.values()) res = Math.max(res, cnt + dup);
        }

        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}