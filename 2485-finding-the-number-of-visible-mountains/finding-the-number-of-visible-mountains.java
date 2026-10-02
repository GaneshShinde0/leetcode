class Solution {
    public int visibleMountains(int[][] peaks) {
        if(peaks.length==1) return 1;
        for(int i=0;i<peaks.length;i++) {
            int x=peaks[i][0], y=peaks[i][1];
            peaks[i][0]=x-y;
            peaks[i][1]=x+y;
        }
        Arrays.sort(peaks,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int count=peaks[0][0]==peaks[1][0]&&peaks[0][1]==peaks[1][1]?0:1;
        int maxRight=peaks[0][1];
        for(int i=0;i<peaks.length;i++) {
            int[] next=peaks[i];
            if(next[1]<=maxRight) continue;
            maxRight=next[1];
            if(i==peaks.length-1||next[0]!=peaks[i+1][0]||maxRight!=peaks[i+1][1]) count++;
        }
        return count;
    }
}