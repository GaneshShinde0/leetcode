class SummaryRanges {
    private Set<Integer> set;
    public SummaryRanges() {
        this.set = new TreeSet<>();
    }
    
    public void addNum(int val) {
        set.add(val);
    }
    
    public int[][] getIntervals() {
        List<int[]> li = new ArrayList<>();
        int left = -1, right = -1;
        for(Integer val:set){
            if(left<0){
                left=right= val;
            }else if(val==right+1){
                right=val;
            }else{
                li.add(new int[]{left,right});
                left = right = val;
            }
        }
        if(left!=-1) li.add(new int[]{left, right});
        int[][] res = new int[li.size()][];
        for(int i=0;i<li.size();i++){
            res[i] = li.get(i);
        }
        return res;
    }
}

class SummaryRangesApproach1 {
    int[] range;
    public SummaryRangesApproach1() {
        this.range = new int[10001];
    }
    
    public void addNum(int value) {
        range[value]++;
    }
    
    public int[][] getIntervals() {
        List<int[]> li = new ArrayList<>();
        int prev = -1;
        for(int i=0;i<=10000;i++){
            if(range[i]>0 && prev==-1){
                prev = i;
            }else if(prev!=-1 && range[i]==0){
                li.add(new int[]{prev,i-1});
                prev = -1;
            }
        }
        if(prev!=-1) li.add(new int[]{prev,10000});
        int[][] res = new int[li.size()][];
        for(int i=0;i<li.size();i++){
            res[i] = li.get(i);
        }
        return res;
    }
}
