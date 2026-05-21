class Solution {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices,(a,b)->Integer.compare(a[0],b[0]));
        int n = stockPrices.length;
        if(n<=2) return n-1;
        int res = 1;
        long prevDx = stockPrices[1][0]-stockPrices[0][0];
        long prevDy = stockPrices[1][1]-stockPrices[0][1];
        
        for(int i=1;i<n-1;i++){
            long currDx = stockPrices[i+1][0]-stockPrices[i][0];
            long currDy = stockPrices[i+1][1]-stockPrices[i][1];

            if(prevDy*currDx!=prevDx*currDy) res++;
            prevDx = currDx;
            prevDy = currDy;
        }
        return res;
    }
    public int minimumLinesFailsSomeTestCasesCauseOfOverflow(int[][] stockPrices) {
        Arrays.sort(stockPrices,(a,b)->Integer.compare(a[0],b[0]));
        int n = stockPrices.length;
        if(n<=2) return n-1;
        int i=1;
        double slope = 0;
        double prevSlope = 1.0*(stockPrices[i][1]-stockPrices[i-1][1])/(stockPrices[i][0]-stockPrices[i-1][0]);
        int res = 1;
        for(;i<n;i++){
            slope = 1.0*(stockPrices[i][1]-stockPrices[i-1][1])/(stockPrices[i][0]-stockPrices[i-1][0]);
            if(Math.abs(slope-prevSlope)>1e-18) res++;
            prevSlope = slope;
        }
        return res;
    }
}