class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        Map<Integer, PriorityQueue<Integer>> adj = new HashMap<>();
        Comparator<Integer> comp = (a,b)->Integer.compare(b,a);
        for(int[] edge:edges){
            adj.computeIfAbsent(edge[0],s->new PriorityQueue<Integer>(comp)).add(vals[edge[1]]);
            adj.computeIfAbsent(edge[1],s->new PriorityQueue<Integer>(comp)).add(vals[edge[0]]);
        }

        int res = Integer.MIN_VALUE;
        for(int i=0;i<vals.length;i++){
            int temp =  k;
            int curr = vals[i];
            PriorityQueue<Integer> ts = new PriorityQueue<>(adj.getOrDefault(i,new PriorityQueue<>()));
            res = Math.max(res,curr);
            while(temp>0 && !ts.isEmpty()){
                curr+=ts.poll();
                res = Math.max(res, curr);
                temp--;
            }
            res = Math.max(res,curr);
        }
        return res;
    }
} 