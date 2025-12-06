class Solution {
     public int countPartitionsTm(int[] nums, int k) {
        int n = nums.length;
        long mod = (long) 1e9 + 7;
        long[] dp = new long[n + 1], prefix = new long[n + 1];
        TreeMap<Integer, Integer> cnt = new TreeMap<>();

        dp[0] = 1;
        prefix[0] = 1;
        for (int i = 0, j = 0; i < n; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            // adjust window
            while (j <= i && cnt.lastKey() - cnt.firstKey() > k) {
                cnt.put(nums[j], cnt.get(nums[j]) - 1);
                if (cnt.get(nums[j]) == 0) {
                    cnt.remove(nums[j]);
                }
                j++;
            }

            dp[i + 1] = (prefix[i] - (j > 0 ? prefix[j - 1] : 0)+mod) % mod;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }

        return (int) dp[n];
    }

    public int countPartitionsLinkedList(int[] nums, int k) {
        int n = nums.length;
        long mod = (long) 1e9 + 7;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();

        dp[0] = 1;
        prefix[0] = 1;
        for (int i = 0, j = 0; i < n; i++) {
            // maintain the maximum value queue
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i]) {
                maxQ.pollLast();
            }
            maxQ.offerLast(i);
            // maintain the minimum value queue
            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i]) {
                minQ.pollLast();
            }
            minQ.offerLast(i);
            // adjust window
            while (
                !maxQ.isEmpty() &&
                !minQ.isEmpty() &&
                nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k
            ) {
                if (maxQ.peekFirst() == j) {
                    maxQ.pollFirst();
                }
                if (minQ.peekFirst() == j) {
                    minQ.pollFirst();
                }
                j++;
            }

            dp[i + 1] = (prefix[i] - (j > 0 ? prefix[j - 1] : 0) + mod) % mod;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }

        return (int) dp[n];
    }
    public int countPartitions(int[] A, int k) {
        int n = A.length, mod = 1_000_000_007, acc = 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        Deque<Integer> minq = new ArrayDeque<>();
        Deque<Integer> maxq = new ArrayDeque<>();
        for (int i = 0, j = 0; j < n; ++j) {
            while (!maxq.isEmpty() && A[j] > A[maxq.peekLast()])
                maxq.pollLast();
            maxq.addLast(j);

            while (!minq.isEmpty() && A[j] < A[minq.peekLast()])
                minq.pollLast();
            minq.addLast(j);

            while (A[maxq.peekFirst()] - A[minq.peekFirst()] > k) {
                acc = (acc - dp[i++] + mod) % mod;
                if (minq.peekFirst() < i)
                    minq.pollFirst();
                if (maxq.peekFirst() < i)
                    maxq.pollFirst();
            }

            dp[j + 1] = acc;
            acc = (acc + dp[j + 1]) % mod;
        }

        return dp[n];
    }
}
/*
Example 1:

Input: nums = [9,4,1,3,7], k = 4

Output: 6

Explanation:

There are 6 valid partitions where the difference between the maximum and minimum elements in each segment is at most k = 4:

[[9], [4], [1], [3], [7]]
[[9], [4], [1], [3, 7]]
[[9], [4], [1, 3], [7]]
[[9], [4, 1], [3], [7]]
[[9], [4, 1], [3, 7]]
[[9], [4, 1, 3], [7]]
*/

/*
9 9 9 9 9
9 4 1 1 1
*/