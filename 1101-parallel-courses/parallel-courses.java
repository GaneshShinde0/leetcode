class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n+1];
        for(int[] rel:relations){
            graph.computeIfAbsent(rel[0],k->new HashSet<Integer>()).add(rel[1]);
            inDegree[rel[1]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            if(inDegree[i]==0)q.add(i);
        }
        int res = 0;
        while(!q.isEmpty()){
            System.out.println(q);
            int size = q.size();
            for(int i=0;i<size;i++){
                int curr = q.poll();
                Set<Integer> set= graph.computeIfAbsent(curr,k->new HashSet<Integer>());
                for(int j:set){
                    inDegree[j]--;
                    if(inDegree[j]==0){
                        q.add(j); 
                    }                   
                }
            }
            res++;
        }
        for(int i:inDegree) if(i!=0) return -1;
        return res;
    }
}