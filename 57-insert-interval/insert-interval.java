class Solution {
    public int[][] insertInitialFailingFewTestCases(int[][] intervals, int[] newInterval) {
        List<int[]> li = new ArrayList<>();
        boolean added = false;
        
        if(intervals.length>0){
            if(newInterval[1]<intervals[0][0]){
                li.add(newInterval);
                added = true;
            }else{
                li.add(intervals[0]);
            }
        }
        int n = intervals.length;
        if(intervals.length==0){
            li.add(newInterval);
            added = true;
        }
        for(int i=0;i<n;i++){
            int[] curr = li.get(li.size()-1);
            System.out.println(Arrays.toString(curr));
            if(curr[1]>=newInterval[0]&&curr[0]<=newInterval[1]){
                curr[1]=Math.max(newInterval[1],curr[1]);
                curr[0] = Math.min(newInterval[0],curr[0]);
                added = true;
            }
            if(curr[1]<newInterval[0] && i+1<n && intervals[i+1][0]>newInterval[1]){
                li.add(newInterval);
                added = true;
            }
            if(curr[1]>=intervals[i][0]&&curr[0]<=intervals[i][1]){
                curr[1]=Math.max(intervals[i][1],curr[1]);
            }
            if(curr[1]<intervals[i][0]){
                li.add(intervals[i]);
            }
        }
        int[] curr = li.get(li.size()-1);
        System.out.println(Arrays.toString(curr));
        if(curr[1]>=newInterval[0]&&curr[0]<=newInterval[1]){
            curr[1]=Math.max(newInterval[1],curr[1]);
            curr[0] = Math.min(newInterval[0],curr[0]);
            added = true;
        }

        if(!added) li.add(newInterval);
        int[][] res = new int[li.size()][2];
        for(int i=0;i<li.size();i++){
            res[i]=li.get(i);
        }
        return res;
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> li = new ArrayList<>();
        int i=0, n = intervals.length;
        while(i<n&&intervals[i][1]<newInterval[0]){
            li.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        li.add(newInterval);
        while(i<n){
            li.add(intervals[i]);
            i++;
        }
        return li.toArray(new int[li.size()][2]);
    }

}