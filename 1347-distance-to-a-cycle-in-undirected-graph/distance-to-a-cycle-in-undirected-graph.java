class Solution {
    public int[] distanceToCycle(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i< n;i++) graph.add(new ArrayList<>());
        int[] res = new int[n];
        int[] count = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<n;i++){
            count[i] = graph.get(i).size();
            if(graph.get(i).size()==1) q.add(i);
        }

        // Set distance of all the nodes which are not in cycle to Integer.MAX_VALUE;
        // Set Count of all the nodes which are not in cycle to 1;
        while(!q.isEmpty()){
            int i = q.poll();
            res[i] = Integer.MAX_VALUE;
            for(int j: graph.get(i)){
                if(count[j]>1 && --count[j]==1){
                    q.add(j);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(count[i]>1) q.add(i);
        }
        
        while(!q.isEmpty()){
            int i = q.poll();
            for(int j:graph.get(i)){
                if(res[j]>res[i]+1){
                    res[j] = res[i]+1;
                    q.add(j);
                }
            }
        }
        return res;
    }
}