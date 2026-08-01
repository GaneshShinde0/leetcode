class Solution {
    public int treeDiameter(int[][] edges) {
        int n = edges.length+1;
        int remainingNodes = n;

        int[] degree = new int[n];
        HashMap<Integer, Set<Integer>> hm = new HashMap<>();
        for(int[] edge:edges){
            int u = edge[0], v = edge[1];
            degree[u]++;
            degree[v]++;
            hm.computeIfAbsent(u, x->new HashSet<Integer>()).add(v);
            hm.computeIfAbsent(v, x->new HashSet<Integer>()).add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                queue.add(i);
            }
        }
        int res = 0;
        while(remainingNodes>2){
            int size = queue.size();
            remainingNodes -= size;
            for(int i=0;i<size;i++){
                int curr = queue.poll();
                Set<Integer> set = hm.get(curr);
                for(int neighbor:set){
                    if(hm.containsKey(neighbor)){
                        degree[neighbor]--;
                        if(degree[neighbor]==1) queue.add(neighbor);
                    }
                }
                if(degree[curr]==0) hm.remove(curr);
            }
            res++;
        }
        return remainingNodes==2?res*2+1:res*2;
    }
}