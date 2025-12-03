class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        Map<Double, List<Double>> slopeToIntercept = new HashMap<>();
        Map<Integer, List<Double>> midToSlope = new HashMap<>();
        int ans = 0;
        double inf = 1e9+7;
        for(int i=0;i<n;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j= i+1;j<n;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dx = x1-x2, dy = y1-y2;
                double k, b;

                if(dx==0){
                    k=inf; // slope
                    b=x1; // x intercept
                }else{
                    k = (1.0*dy)/dx; // Slope
                    // Formula for y intercept is y=mx+c;
                    // y = (dy/dx)*x+c; // c is the x intercept
                    // c = y-(dy/dx)*x;
                    // b = y1-k*x1;
                    b = (1.0 * (y1 * dx - x1 * dy)) / dx;

                }
                if(k==-0.0) k= 0.0;
                if(b==-0.0) b= 0.0;

                int mid = (x1+x2)*10000+(y1+y2);
                slopeToIntercept.computeIfAbsent(k,key-> new ArrayList<>()).add(b);
                midToSlope.computeIfAbsent(mid,key->new ArrayList<>()).add(k);
            }
        }

        for(List<Double> sti: slopeToIntercept.values()){
            if(sti.size()==1) continue;
            Map<Double, Integer> cnt = new TreeMap<>();
            for(double intercept:sti){
                cnt.put(intercept, cnt.getOrDefault(intercept,0)+1);
            }
            int sum = 0;
            for(int count:cnt.values()){
                ans += sum*count;
                sum += count;
            }
        }

        for(List<Double> mts: midToSlope.values()){
            if(mts.size()==1) continue;
            Map<Double, Integer> cnt = new TreeMap<>();
            for(double k: mts){
                cnt.put(k,cnt.getOrDefault(k,0)+1);
            }
            int sum = 0;
            for(int count : cnt.values()){
                ans -= sum*count;
                sum +=count;
            }
        }
        return ans;
    }
}