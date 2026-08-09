class Solution {
    public int[][] findMaximalUncoveredRanges(int n, int[][] ranges) {
        Arrays.sort(ranges,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        });
        int lower = 0, upper = n-1;
        int rLen = ranges.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<rLen;i++){
            if(lower<ranges[i][0]){
                res.add(Arrays.asList(lower,ranges[i][0]-1));
            }
            lower=Math.max(ranges[i][1]+1,lower);
        }
        if(lower<=upper)res.add(Arrays.asList(lower,upper));
        int[][] arr = res.stream()
                    .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                    .toArray(int[][]::new);
        return arr;
    }
}