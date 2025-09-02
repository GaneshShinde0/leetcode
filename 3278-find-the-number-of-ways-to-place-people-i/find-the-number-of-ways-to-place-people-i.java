class Solution {

    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public int numberOfPairsDoesNotWork(int[][] points) {
        int n = points.length;
        int count = 0;
        for(int i=0;i<points.length;i++){
            for(int j = i+1;j<points.length;j++){
                if(i==j) continue;
                if(!isPointPresent(points, points[i], points[j])&& points[i][1]>=points[j][1] &&points[i][0]<=points[j][0]){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPointPresent(int[][] points, int[] first, int[] second){
        int x1 = first[0], x2 = second[0], y1 = first[1], y2 = second[1];
        for(int i=0;i<points.length; i++){
            if((points[i][0]>x1 && points[i][0]<x2) && (points[i][1]>y1 && points[i][1]<y2)) return true;
        }
        return false;
    }
    public int numberOfPairsInitialSolutionFailsFewTestCases(int[][] points) {
        Arrays.sort(points,(a,b)->{
            if(b[1]==a[1]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(b[1],a[1]);
        });
        for(int[] arr:points){
            System.out.println(Arrays.toString(arr));
        }
        int count = 0;
        for(int i=1;i<points.length;i++){
            if(points[i-1][1]>=points[i][1] &&points[i-1][0]<=points[i][0]){
                count++;
            }
        }
        return count;
    }


    public int numberOfPairs(int[][] points){
        int ans = 0;
        int n = points.length;
        for(int i=0;i<n; i++){
            int[] pointA = points[i];
            for(int j=0; j<n; j++){
                int[] pointB = points[j];
                if(i==j || !(pointA[0]<=pointB[0] && pointA[1]>=pointB[1])) continue;
                if(n==2){
                    ans++;
                    continue;
                }

                boolean illegal = false;
                for(int k=0; k<n; k++){
                    if(k==i||k==j) continue;
                    int[] pointTmp = points[k];
                    boolean isXContained = pointTmp[0]>=pointA[0] && pointTmp[0]<=pointB[0];
                    boolean isYContained = pointTmp[1]<=pointA[1] && pointTmp[1]>=pointB[1];
                    if(isXContained && isYContained){
                        illegal = true;
                        break;
                    }
                }
                if(!illegal) ans++;
            }
        }
        return ans;
    }
}