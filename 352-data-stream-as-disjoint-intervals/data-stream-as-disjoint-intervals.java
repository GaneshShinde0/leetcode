class SummaryRanges {
    int[] range;
    public SummaryRanges() {
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

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */