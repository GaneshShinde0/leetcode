class Solution {
    public int numberOfPaths(int n, int[][] corridors) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 1; i <= n; i++) g.put(i, new HashSet<>());
        
		//build the graph, we count only neighbours with higher index
        for (int[] e: corridors) {
            if (e[0] < e[1]) g.get(e[0]).add(e[1]);
            else g.get(e[1]).add(e[0]);
        }
        
        int res = 0;
		//for every edge we count common neighbours
        for (int[] e: corridors) {
            Set<Integer> s0 = g.get(e[0]);
            Set<Integer> s1 = g.get(e[1]);
            for (int k: s0) {
                if (s1.contains(k)) res++;
            }
        }
        
        return res;
    }
}