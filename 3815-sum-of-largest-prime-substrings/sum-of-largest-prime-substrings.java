class Solution {
    public long sumOfLargestPrimes(String s) {
        TreeSet<Long> primeSet = new TreeSet<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            long temp = 0;
            for (int j = i; j < n; ++j) {
                temp = temp * 10 + (s.charAt(j) - '0');
                if (isPrime(temp)) {
                    primeSet.add(temp);
                }
                if(primeSet.size()>3)primeSet.removeFirst();
            }
        }
        long result = 0;
        for(long i:primeSet) result+=i;
        return result;
    }
    private boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; ++i)
            if (n % i == 0) return false;
        return true;
    }
}