/*
When depth => 1 => res = 1
depth = 2 -> res = 2
depth = 3=> 
    1 2 2
    2 1 2
    2 2 1
    1 1 1
    4 ways.
depth = > 4
    1 1 1 2
    1 1 2 1
    1 2 1 1
    2 1 1 1
    1 2 2 2
    2 1 2 2
    2 2 1 2
    2 2 2 1

When Depth is odd... 1s will be odd (1+3+...Until Depth) (2's will be even)
When Depth is even... 1s will be odd ....(2s will be odd)..
    2 * getWays(n-1);
*/

class Solution {
    private final int MOD = 1_000_000_007;
    public int assignEdgeWeights(int[][] edges) {
        int maxDepth = getMaxDepth(edges);
        return getWays(maxDepth-1);
    }
    int getWays(int n){
        if(n==0) return 1;
        int ways = getWays(n/2)%MOD;
        ways = (int) ((1l*ways*ways)%MOD);
        if(n%2==1) return (2*ways)%MOD;
        else return ways%MOD;
    }
    private int getMaxDepth(int[][] edges){
        int maxDepth = -1;
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        boolean[] vis = new boolean[edges.length+2];
        for(int[] edge:edges){
            hm.computeIfAbsent(edge[0],k->new HashSet<Integer>()).add(edge[1]);
            hm.computeIfAbsent(edge[1],k->new HashSet<Integer>()).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                int curr = queue.poll();
                vis[curr]=true;
                if(!hm.containsKey(curr)) continue;
                for(int neigh:hm.get(curr)){
                    if(!vis[neigh]) queue.add(neigh);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }
}