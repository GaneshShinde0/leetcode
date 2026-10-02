class Solution {
    int res = 0;
    
    public int numberOfNodes(int n, int[] queries) {
        int[] counts = new int[n + 1];
        for (int q : queries) {
            counts[q]++;
        }
        dfs(1, 0, counts);
        return res;
    }
    
    private void dfs(int x, int cnt, int[] counts) {
        if (x >= counts.length) return;
        cnt += counts[x];
        if (cnt % 2 == 1) res++;
        dfs(2 * x, cnt, counts);
        dfs(2 * x + 1, cnt, counts);
    }
}