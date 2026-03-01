class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] res = new int[n];
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                int distance = Math.abs(j-i);
                distance = Math.min(distance, Math.abs(j-x)+Math.abs(i-y)+1);
                distance = Math.min(distance, Math.abs(j-y)+Math.abs(i-x)+1);
                res[distance-1]+=2;
            }
        }
        return res;
    }
}