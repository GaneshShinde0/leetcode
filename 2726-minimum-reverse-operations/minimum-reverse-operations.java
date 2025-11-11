class Solution {
    public int[] minReverseOperationsTLE(int n, int p, int[] banned, int k) {
        int[] res = new int[n];
        Arrays.fill(res,-1);
        boolean[] visited = new boolean[n];
        visited[p] = true;
        res[p] = 0;
        for(int i:banned){
            visited[i] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(p);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            int best_lft = Math.max(0,curr-k+1);
            int best_lft_l = best_lft;
            int best_lft_r = best_lft_l+k-1;

            int best_rgt = Math.min(n-1,curr+k-1);
            int best_rgt_r = best_rgt;
            int best_rgt_l = best_rgt_r-k+1;

            int l = best_lft_l + best_lft_r - curr;
            int r = best_rgt_l + best_rgt_r - curr;
            for(int i=l;i<=r;i+=2){
                if(visited[i]) continue;
                res[i]=res[curr]+1;
                queue.add(i);
                visited[i] = true;
            }
        }

        return res;
    }
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] res = new int[n];
        Arrays.fill(res, -1);

        // Maintain two TreeSets for available indices (unvisited and not banned)
        TreeSet<Integer> even = new TreeSet<>();
        TreeSet<Integer> odd = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) even.add(i);
            else odd.add(i);
        }

        for (int b : banned) {
            if (b % 2 == 0) even.remove(b);
            else odd.remove(b);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(p);
        res[p] = 0;

        // Mark start as visited
        if (p % 2 == 0) even.remove(p);
        else odd.remove(p);

        while (!q.isEmpty()) {
            int cur = q.poll();

            // Compute reachable window boundaries
            int left = Math.max(cur - k + 1, k - 1 - cur);
            int right = Math.min(cur + k - 1, 2 * n - k - cur - 1);

            TreeSet<Integer> set = (left % 2 == 0) ? even : odd;

            for (Integer nxt = set.ceiling(left); nxt != null && nxt <= right; nxt = set.higher(nxt)) {
                res[nxt] = res[cur] + 1;
                q.offer(nxt);
            }

            // Remove visited indices
            set.subSet(left, true, right, true).clear();
        }

        return res;
    }
}
