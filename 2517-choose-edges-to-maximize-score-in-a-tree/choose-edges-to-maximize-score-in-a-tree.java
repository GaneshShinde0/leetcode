class Solution {
    public long maxScore(int[][] edges) {
        int root = 0, n = edges.length;
        List<int[]>[] map = new ArrayList[n];
        Arrays.setAll(map, o-> new ArrayList<>());
        for(int i=0;i<n;i++){
            if(edges[i][0]>=0){
                map[edges[i][0]].add(new int[]{i, edges[i][1]});
            }else{
                root = i;
            }
        }
        return dfs(0, root, map, new Long[n][2]);
    }

    private long dfs(int mode, int curr, List<int[]>[] map, Long[][] memo){
        if(memo[curr][mode]!=null) return memo[curr][mode];
        long skip = 0, take = 0;
        for(int[] m: map[curr]){
            skip += dfs(0, m[0],map, memo);
        }
        if(mode == 0){
            for(int[] m:map[curr]){
                take = Math.max(take, skip-dfs(0, m[0], map, memo)+dfs(1,m[0],map, memo)+m[1]);
            }
        }
        return memo[curr][mode] = Math.max(take, skip);
    }
}