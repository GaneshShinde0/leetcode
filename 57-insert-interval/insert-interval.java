class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> li = new ArrayList<>();
        int i = 0;
        while(i<intervals.length && intervals[i][1]<newInterval[0]) li.add(intervals[i++]);
        // Merge all overlapping intervals to one considering newInnterval
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        li.add(newInterval);
        while(i<intervals.length) li.add(intervals[i++]);
        int[][] res = new int[li.size()][2];
        for(i=0;i<res.length;i++){
            res[i] = li.get(i);
        }
        return res;
    }
}