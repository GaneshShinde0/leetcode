class Solution {
    public int minOperations(int[] nums, int sum) {
        final int INF = 1_000_000;

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int x : nums) {
            // (value, minimum operations)
            List<int[]> options = new ArrayList<>();
            long value = x;
            int divCost = 0;
            while(value > 0){
                long curr = value;
                int cost = divCost;
                while(curr<=sum){
                    options.add(new int[]{(int)curr, cost});
                    curr*=2;
                    cost++;
                }
                value/=2;
                divCost++;
            }
            for (int s = sum; s >=0; s--) {
                if (dp[s] == INF) continue;
                for (int[] option: options) {
                    int val = option[0];
                    int cost = option[1];
                    if (s + val <= sum) {
                        dp[s + val] = Math.min(dp[s + val], dp[s] + cost);
                    }
                }
            }

        }

        return dp[sum] == INF ? -1 : dp[sum];
    }
}

class SolutionInitial {
    public int minOperationsInititial(int[] nums, int sum) {
        final int INF = 1_000_000;
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int x : nums) {
            // (value, minimum operations)
            List<int[]> options = new ArrayList<>();
            long value = x;
            int divCost = 0;
            while(value > 0){
                long curr = value;
                int cost = divCost;
                while(curr<=sum){
                    options.add(new int[]{(int)curr, cost});
                    curr*=2;
                    cost++;
                }
                value/=2;
                divCost++;
            }
            int[] next = Arrays.copyOf(dp, sum + 1);

            for (int s = 0; s <= sum; s++) {
                if (dp[s] == INF) continue;
                for (int[] option: options) {
                    int val = option[0];
                    int cost = option[1];
                    if (s + val <= sum) {
                        next[s + val] = Math.min(
                            next[s + val],
                            dp[s] + cost
                        );
                    }
                }
            }

            dp = next;
        }
        return dp[sum] == INF ? -1 : dp[sum];
    }
}