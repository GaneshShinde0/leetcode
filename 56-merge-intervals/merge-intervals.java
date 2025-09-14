class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->
            Integer.compare(a[0],b[0])
        );
        res.add(intervals[0]);
        int curr = 0;
        for(int i=1;i<intervals.length;i++){
            int[] arr = res.get(curr);
            int[] interval = intervals[i];
            if(arr[1]>=interval[0]){
                arr[1]=Math.max(arr[1],interval[1]);
            }else{
                res.add(intervals[i]);
                curr++;
            }
        }
        int[][] finalRes = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            finalRes[i]=res.get(i);
        }
        return finalRes;
    }
}