class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] posAndSpeed = new double[n][2];
        for(int i=0;i<n;i++){
            posAndSpeed[i][0] = position[i];
            posAndSpeed[i][1] = 1.0*(target-position[i])/speed[i];
        }
        Arrays.sort(posAndSpeed, (a,b)->Double.compare(a[0],b[0]));
        int res = 0;
        double curr = 0;
        for(int i=n-1;i>=0;i--){
            if(posAndSpeed[i][1]>curr){
                curr = posAndSpeed[i][1];
                res++;
            }
        }
        return res;
    }
}