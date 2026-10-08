class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> li = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        li.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i=1;i<intervals.length;i++){
            int[] prev = li.get(li.size()-1);
            if(prev[1]>=intervals[i][0]){
                prev[1] = Math.max(intervals[i][1], prev[1]);
            }else{
                li.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        int[][] res = new int[li.size()][2];
        for(int i=0;i<res.length;i++){
            res[i] = li.get(i);
        }
        return res;
    }
}