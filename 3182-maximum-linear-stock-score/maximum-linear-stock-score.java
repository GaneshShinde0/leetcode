
class Solution {
    public long maxScore(int[] prices) {
        Map<Integer, Long> map = new HashMap<>();
        long res = 0;
        for (int i = 0; i < prices.length; i ++) {
            int diff = prices[i] - i;
            map.put(diff, map.getOrDefault(diff, (long)0) + (long)prices[i]);
            res = Math.max(res, map.get(diff));
        }
        return res;
    }
}