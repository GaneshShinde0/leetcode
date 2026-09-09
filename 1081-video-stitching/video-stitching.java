class Solution {
    public int videoStitching(int[][] clips, int time) {
        int[] endTime= new int[101];
        for(int[] clip:clips){
            endTime[clip[0]] = Math.max(clip[1], endTime[clip[0]]);
        }
        for(int i=1;i<time+1;i++){
            endTime[i] = Math.max(endTime[i],endTime[i-1]);
        }
        int res = 0;
        int max = 0, curr=0;
        for(int i=0;i<time;i++){
            max = Math.max(endTime[i], max);
            if(i==curr){
                res++;
                curr=max;
            }
            if(i>max) return -1;
        }
        if(curr<time) return -1;
        return res;
    }
}