class Solution {
    int mod = 1000000007;
    Long[][][] cache;

    public int countOfArrays(int n, int m, int k) {
        cache = new Long[n][k + 1][2];
        return (int) helper(n, m, k, 0, 0, 0) % mod;
    }

    private long helper(int n, int m, int k, int index, int count, int prevEven) {
        if (index >= n) {
            return count == k ? 1 : 0;
        }
        if (count > k) { // Early pruning
            return 0;
        }
        if (cache[index][count][prevEven] != null) {
            return cache[index][count][prevEven];
        }
        long currEven = (m / 2 * helper(n, m, k, index + 1, count + prevEven, 1)) % mod;
        long currOdd = ((m + 1) / 2 * helper(n, m, k, index + 1, count, 0)) % mod;
        cache[index][count][prevEven] = (currEven + currOdd) % mod;
        return cache[index][count][prevEven];
    }
}