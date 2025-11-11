class Solution {
    public int[] findRightIntervalInitial(int[][] intervals) {
        TreeSet<int[]> set = new TreeSet<>((a,b)->{
                    if(a[1]==b[0]) return Integer.compare(a[0],b[0]);
                    return Integer.compare(a[1],b[0]); 
                }
            );
        int idx = 0;
        for(int[] i:intervals){
            set.add(new int[]{i[0],i[1],idx});
            idx++;
        }
        // for(int[] i: set){
        //     System.out.println(Arrays.toString(i));
        // }
        int n = intervals.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int[] temp = set.ceiling(intervals[i]);
            if(temp==null){
                res[i]=-1; 
                continue;
            }
            if(Arrays.equals(intervals[i],temp)){
                res[i] = -1;
            }else{
                res[i] = temp[2];
            }
        }
        return res;
    }

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        // Store each interval’s start with its original index
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            // Find the smallest start >= current interval’s end
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            res[i] = (entry == null) ? -1 : entry.getValue();
        }
        return res;
    }
}