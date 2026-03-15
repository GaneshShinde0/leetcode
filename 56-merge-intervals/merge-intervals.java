class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> listOfResult = new ArrayList<>();
        listOfResult.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] prev= listOfResult.get(listOfResult.size()-1);
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(prev[1]>=start){
                prev[1] = Math.max(end,prev[1]);
            }else{
                listOfResult.add(intervals[i]);
            }
        }
        int[][] res = new int[listOfResult.size()][];
        for(int i=0;i<listOfResult.size();i++){
            res[i] = listOfResult.get(i);
        }
        return res;
    }
}