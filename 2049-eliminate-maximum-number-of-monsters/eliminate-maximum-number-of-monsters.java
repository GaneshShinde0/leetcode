/*
Input: dist = [1,3,4], speed = [1,1,1]
Initially

Time to reach = distance/speed;

*/
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] timeToReach = new int[n];
        for(int i=0;i<n;i++) timeToReach[i] = (int) Math.ceil(1.0*dist[i]/speed[i]);
        Arrays.sort(timeToReach);
        int res = 1;
        for(int i=1;i<n;i++){
            if(res==timeToReach[i] && timeToReach[i]==timeToReach[i-1]) return res;
            res++;
        }
        return res;
    }
}