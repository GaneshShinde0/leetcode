class Solution {
    public int removeCoveredIntervalsInitial(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        });
        List<int[]> li = new ArrayList<>();
        li.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] prev = li.get(li.size()-1);
            if(intervals[i][1]<=prev[1]) continue;
            else if(prev[0]==intervals[i][0] && prev[1]<=intervals[i][1]){
                prev[1] =intervals[i][1];
            }
            else{
                li.add(intervals[i]);
            }
        }
        return li.size();
    }
    public int removeCoveredIntervals1(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        });
        int count = 0, prevStart=-1, prevEnd = -1;
        for(int[] curr:intervals){
            if(curr[0]>prevStart&&curr[1]>prevEnd){
                count++;
                prevStart=curr[0];
                prevEnd = curr[1];
            }else if(curr[0]==prevStart && curr[1]>prevEnd){
                prevEnd = curr[1];
            }else if(curr[1]<=prevEnd){
                continue;
            }
        }
        return count;
    }
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            // Sort by start point.
            // If two intervals share the same start point,
            // put the longer one to be the first.
            return o1[0] == o2[0] ? o2[1] - o1[1]: o1[0] - o2[0];
        }
        });

        int count = 0;
        int end, prev_end = 0;
        for (int[] curr : intervals) {
        end = curr[1];
        // if current interval is not covered
        // by the previous one
        if (prev_end < end) {
            ++count;
            prev_end = end;
        }
        }
        return count;
    }
}