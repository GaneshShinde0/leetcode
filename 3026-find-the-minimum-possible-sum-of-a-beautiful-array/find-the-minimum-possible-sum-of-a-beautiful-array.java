class Solution {
    private final int MOD = 1_000_000_007;
    public int minimumPossibleSumTLE(int n, int target) {
        long res = 0, i=1, remaining = 0;
        Set<Long> taken = new HashSet<>();
        while(remaining<n){
            if(!taken.contains(i) && !taken.contains(target-i)){
                taken.add(i);
                remaining++;
            }
            i++;
        }
        for(long temp:taken) res+=temp;
        return (int)(res%1_000_000_007);
    }
    public int minimumPossibleSum(int n, int target) {
        long k = target / 2;
        if (n <= k)
            return (int) ((1L * n * (n + 1) / 2)%MOD);
        return (int) ((k * (k + 1) / 2 + (1l*target + target + n - k - 1l) * (n - k) / 2)%MOD);
    }
}