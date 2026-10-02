import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int totalXor = 0;
        boolean allEqual = true;

        // Collect all distinct values from nums 
        Set<Integer> distinctSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            totalXor ^= nums[i];
            distinctSet.add(nums[i]);
            if (i > 0 && nums[i] != nums[0]) {
                allEqual = false;
            }
        }

        // 1. If total XOR is already 0, 0 operations are required
        if (totalXor == 0) {
            return 0;
        }

        // 2. If all elements are equal and n is odd, no distinct pair can be chosen
        if (allEqual) {
            return -1;
        }

        int[] uniqueValues = new int[distinctSet.size()];
        int idx = 0;
        for (int v : distinctSet) {
            uniqueValues[idx++] = v;
        }

        // 3. BFS to find minimum number of elements whose XOR equals totalXor
        int maxMask = 2048;
        int[] dist = new int[maxMask];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        dist[0] = 0;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == totalXor) {
                break;
            }

            for (int val : uniqueValues) {
                int next = curr ^ val;
                if (next < maxMask && dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }

        int d = dist[totalXor];

        // 4. Per Hint 3: valid if d < nums.length, otherwise impossible
        return (d != -1 && d < n) ? d : -1;
    }
}