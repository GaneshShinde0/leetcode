class Solution {
    public long maxProfit(int[] workers, int[][] tasks) {
        long profit = 0;
        Map<Integer, PriorityQueue<Integer>> skillToProfit = new HashMap<>();
        for(int[] task:tasks){
            skillToProfit.computeIfAbsent(task[0],k->new PriorityQueue<Integer>((a,b)->Integer.compare(b,a))).add(task[1]);
        }
        for(int worker:workers){
            if(skillToProfit.containsKey(worker)){
                profit += skillToProfit.get(worker).poll();
                if(skillToProfit.get(worker).size()==0) skillToProfit.remove(worker);
            }
        }
        if(skillToProfit.size()>0){
            int max = 0;
            for(Map.Entry<Integer, PriorityQueue<Integer>> e:skillToProfit.entrySet()){
                max=Math.max(max,e.getValue().poll());
            }
            profit+=max;
        }
        return profit;
    }
}