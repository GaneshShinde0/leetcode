/*
Jobs    => 3,9,15,18
Workers => 1,3,5,6

Jobs    => 3,90,150,180
Workers => 35,40,41,60
*/
class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int res = 0;
        for(int i=jobs.length-1;i>=0;i--){
            res = Math.max(res,(workers[i]+jobs[i]-1)/workers[i]);
        }
        return res;
    }
}