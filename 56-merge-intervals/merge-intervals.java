class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> li = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int start = intervals[0][0], end = intervals[0][1];
        // li.add(new int[]{intervals[0][0], intervals[0][1]});
        for(int i=0;i<intervals.length;i++){
            int currStart = intervals[i][0], currEnd = intervals[i][1];
            if(currStart<=end) end = Math.max(end, currEnd);
            else{
                li.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            }
        }
        li.add(new int[]{start, end});
        int[][] res = new int[li.size()][2];
        for(int i=0;i<li.size();i++){
            res[i] = li.get(i);
        }
        return res;
    }
}