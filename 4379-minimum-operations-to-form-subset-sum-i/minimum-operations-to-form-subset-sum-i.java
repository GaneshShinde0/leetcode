class Solution {
    public int minOperations(int[] nums, int sum) {
        final int INF = 1_000_000;

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int x : nums) {
            // (value, minimum operations)
            List<int[]> options = new ArrayList<>();

            // x, 2x, 4x, ...
            long v = x;
            int ops = 0;

            while (v <= sum) {
                options.add(new int[]{(int) v, ops});

                v *= 2;
                ops++;

                if (v > sum) break;
            }

            // floor(x/2), floor(x/4), ...
            v = x;
            ops = 0;

            while (v > 0) {
                v /= 2;
                ops++;

                if (v == 0) break;

                options.add(new int[]{(int) v, ops});
            }

            // Remove duplicate resulting values, keeping minimum cost.
            Map<Integer, Integer> best = new HashMap<>();
            for (int[] op : options) {
                best.merge(op[0], op[1], Math::min);
            }
            options.forEach(t->System.out.print(Arrays.toString(t)));
            System.out.println();
            int[] next = Arrays.copyOf(dp, sum + 1);

            for (int s = 0; s <= sum; s++) {
                if (dp[s] == INF) continue;

                for (Map.Entry<Integer, Integer> entry : best.entrySet()) {
                    int value = entry.getKey();
                    int cost = entry.getValue();

                    if (s + value <= sum) {
                        next[s + value] = Math.min(next[s + value], dp[s] + cost);
                    }
                }
            }

            dp = next;
        }

        return dp[sum] == INF ? -1 : dp[sum];
    }
}