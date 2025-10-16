class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[1],b[1]));
        for(int i=1;i<intervals.length;i++){
            if(intervals[i-1][1]>intervals[i][0]){
                return false;
            }
        }
        return true;
    }
}