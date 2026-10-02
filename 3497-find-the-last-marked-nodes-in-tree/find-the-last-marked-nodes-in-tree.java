class Solution {
    public int[] lastMarkedNodes(int[][] edges) {
        List<Integer>[] links = new ArrayList[edges.length + 1];
        for (int i = 0; i < links.length; i++) {
            links[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            links[edge[0]].add(edge[1]);
            links[edge[1]].add(edge[0]);
        }
        hs = new long[links.length];
        dfs(links, 0, -1, 0);
        System.out.println(Arrays.toString(hs));
        dfsRev(links, 0, -1, 0);
        int[] res = new int[links.length];
        for (int i = 0; i < hs.length; i++) {
            res[i] = (int) (hs[i] % links.length);
        }
        return res;
    }

    long[] hs;

    public long dfs(List<Integer>[] links, int i, int prv, long h) {
        long res = i;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            res = Math.max(res, dfs(links, next, i, h + links.length));
            h = Math.max(h, res);
        }
        hs[i] = h;
        return res + links.length;
    }

    public long dfsRev(List<Integer>[] links, int i, int prv, long h) {
        long res = i;
        for (int j = links[i].size() - 1; j >= 0; j--) {
            int next = links[i].get(j);
            if (next == prv)
                continue;
            res = Math.max(res, dfsRev(links, next, i, h + links.length));
            h = Math.max(h, res);
        }
        hs[i] = Math.max(hs[i], h);
        return res + links.length;
    }
}