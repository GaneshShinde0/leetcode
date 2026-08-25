class Solution {
    public double minAreaFreeRect(int[][] points) {
        HashMap<String,int[]> hm = new HashMap<>();
        for(int[] point:points) hm.put(point[0]+"-"+point[1], point);
        int n = points.length;
        double res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int xI = points[i][0], yI = points[i][1];
                int xJ = points[j][0], yJ = points[j][1];
                for(int k=j+1;k<n;k++){
                    int xK = points[k][0], yK = points[k][1];
                    int x4 = xJ+xK-xI;
                    int y4 = yJ+yK-yI;
                    int v1x = xJ - xI, v1y = yJ - yI;
                    int v2x = xK - xI, v2y = yK - yI;
                    if (v1x * v2x + v1y * v2y == 0 && hm.containsKey(x4+"-"+y4)){
                        double area = Math.sqrt((v1x * v1x + v1y * v1y) * 1.0 *
                        (v2x * v2x + v2y * v2y));
                        res = Math.min(res, Math.sqrt((v1x*v1x+v1y*v1y) *1.0
                        * (v2x*v2x+v2y*v2y)));
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}