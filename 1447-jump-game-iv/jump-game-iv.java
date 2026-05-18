class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer,Set<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.computeIfAbsent(arr[i],x->new HashSet<>()).add(i);
        }
        queue.add(0);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int curr = queue.poll();
                vis[curr] = true;
                if(curr==n-1) return depth;
                if(curr+1<n && !vis[curr+1]){
                    queue.add(curr+1);
                }
                if(curr-1>=0 && !vis[curr-1]){
                    queue.add(curr-1);
                }
                if(!graph.containsKey(arr[curr])) continue;
                for(int jumps:graph.get(arr[curr])){
                    if(!vis[jumps]){
                        queue.add(jumps);
                    }                 
                }
                graph.remove(arr[curr]);
            }
            depth++;
        }
        return depth;
    }
}