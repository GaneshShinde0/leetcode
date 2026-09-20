class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rows = topoSort(rowConditions,k+1);
        List<Integer> cols = topoSort(colConditions,k+1);
        if(rows.size()==0 || cols.size()==0) return new int[0][0];
        System.out.println(rows);
        System.out.println(cols);
        int[][] res = new int[k][k];
        int row = 0, col = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rows.get(i).equals(cols.get(j))) {
                    res[i][j] = rows.get(i);
                }
            }
        }
        return res;
    }
    private List<Integer> topoSort(int[][] edges, int n){
        int[] degree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge:edges){
            map.computeIfAbsent(edge[0], x->new ArrayList<Integer>()).add(edge[1]);
            degree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> li = new ArrayList<>();
        for(int i=1;i<n;i++){
            if(degree[i]==0)queue.add(i);
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            li.add(curr);
            if(!map.containsKey(curr)) continue;
            for(Integer neighbor: map.get(curr)){
                degree[neighbor]--;
                if(degree[neighbor]==0) queue.add(neighbor);
            }
        }
        if(li.size()!=n-1) return new ArrayList<>();
        return li;
    }
}