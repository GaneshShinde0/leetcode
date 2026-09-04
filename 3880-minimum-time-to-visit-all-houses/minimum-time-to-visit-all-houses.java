class Solution {
    public long minTotalTime(int[] forward, int[] backward, int[] queries) {
        int n = forward.length, m = queries.length;
        long[] forwardPref = new long[n+1];
        long[] reversePref = new long[n+1];
        for(int i=0;i<n;i++){
            forwardPref[i+1] = forwardPref[i]+forward[i];
            reversePref[i+1] = reversePref[i]+ ((i<n-1)?backward[i+1]:backward[0]);
        }

        long res = 0;
        int curr = 0;
        for(int q:queries){
            int u = curr, v = q;
            long fd = u<=v?forwardPref[v]-forwardPref[u] : forwardPref[n]-(forwardPref[u]-forwardPref[v]);
            long bd = u>=v?reversePref[u]-reversePref[v] : reversePref[n]-(reversePref[v]-reversePref[u]);
            res += Math.min(fd, bd);
            curr = v;
        }
        return res;
    }
}