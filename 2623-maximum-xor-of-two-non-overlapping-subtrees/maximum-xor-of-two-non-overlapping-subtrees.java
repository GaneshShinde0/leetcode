class Solution {
    // time = O(nlogn), space = O(n)
    List<Integer>[] graph;
    long[] w;
    int[] values;
    long res = 0;
    TrieNode root;
    public long maxXor(int n, int[][] edges, int[] values) {
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] x : edges) {
            int a = x[0], b = x[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        w = new long[n];
        this.values = values;
        dfs(0, -1);

        root = new TrieNode();
        for (int x : graph[0]) {
            dfs2(x, 0);
        }
        return res;
    }

    private void dfs2(int u, int fa) {
        long x = w[u], sum = 0;
        TrieNode node = root;
        for (int i = 46; i >= 0; i--) {
            int t = (int)(x >> i & 1);
            if (node.next[1 - t] != null) {
                node = node.next[1 - t];
                sum = sum * 2 + 1;
            } else if (node.next[t] != null) {
                node = node.next[t];
                sum = sum * 2;
            } else break;
        }
        res = Math.max(res, sum);

        for (int next : graph[u]) {
            if (next == fa) continue;
            dfs2(next, u);
        }
        insert(x);
    }

    private void insert(long x) {
        TrieNode node = root;
        for (int i = 46; i >= 0; i--) {
            int t = (int)(x >> i & 1);
            if (node.next[t] == null) node.next[t] = new TrieNode();
            node = node.next[t];
        }
    }

    private long dfs(int u, int fa) {
        w[u] += values[u];
        for (int next : graph[u]) {
            if (next == fa) continue;
            w[u] += dfs(next, u);
        }
        return w[u];
    }

    private class TrieNode {
        private TrieNode[] next;
        public TrieNode() {
            this.next = new TrieNode[2];
        }
    }
}