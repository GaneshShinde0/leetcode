class Solution {
        Map<Integer, Map<Integer, Integer>> G = new HashMap<>();
    int[] res;

    public int[] minEdgeReversals(int n, int[][] edges) {
        G.clear();
        for (int[] e : edges) {
            G.computeIfAbsent(e[0], x -> new HashMap<>()).put(e[1], 0);
            G.computeIfAbsent(e[1], x -> new HashMap<>()).put(e[0], 1);
        }

        res = new int[n];
        Arrays.fill(res, -1);

        dfs(0, dp(-1, 0));
        return res;
    }

    private int dp(int i, int j) {
        int sum = 0;
        for (Integer k : G.get(j).keySet()) {
            if (k == i) continue;
            sum += dp(j, k) + G.get(j).get(k);
        }
        return sum;
    }

    private void dfs(int i, int v) {
        res[i] = v;
        for (Integer j : G.get(i).keySet())
            if (res[j] < 0)
                dfs(j, v - G.get(i).get(j) + G.get(j).get(i));
    }
}