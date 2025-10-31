class Solution {
    public int maxPoints(int[][] points) {
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
                System.out.println("Slope: +"+slope+", Points: "+slopeToPoints.get(slope));
                res = Math.max(slopeToPoints.get(slope).size(),res);
            }
        }
        return res;
    }
}