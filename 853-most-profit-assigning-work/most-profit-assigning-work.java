class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length, m = worker.length;
        int[][] diffToProfit = new int[n][2];
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i=0;i<n;i++){
            tm.put(difficulty[i], Math.max(tm.getOrDefault(difficulty[i],0), profit[i]));
        }
        List<Integer> li = new ArrayList<>(tm.keySet());
        int maxProfit = 0;
        for(int i:li){
            maxProfit = Math.max(tm.get(i), maxProfit);
            tm.put(i,maxProfit);
        }
        int res = 0;
        for(int i=0;i<m;i++){
            Map.Entry<Integer,Integer> e = tm.floorEntry(worker[i]);
            res+=e==null?0:e.getValue();
        }
        return res;
    }
}