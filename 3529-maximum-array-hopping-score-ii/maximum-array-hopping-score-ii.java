class Solution {
    public long maxScore(int[] arr) {
        int cur = arr.length - 1;
        long res = 0;
        // Calculate the score dynamically without storing indices
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > arr[cur] || i == 0) {
                int from = i;
                int to = cur;
                res += (to - from) * (long) arr[to];
                cur = i;
            }
        }
        return res;
    }
}