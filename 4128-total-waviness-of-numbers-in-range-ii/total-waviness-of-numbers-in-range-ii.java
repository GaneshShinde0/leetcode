class Solution {
    private static final List<Integer> WAVES = new ArrayList<>();
    private static final long[] POW10 = new long[19];
    
    // Precompute all valid 3-digit wave patterns and powers of 10
    static {
        for (int i = 0; i < 1000; i++) {
            int r = i % 10;
            int m = (i / 10) % 10;
            int l = (i / 100) % 10;
            if ((m > Math.max(l, r)) || (m < Math.min(l, r))) {
                WAVES.add(i);
            }
        }
        
        POW10[0] = 1;
        for (int i = 1; i < 19; i++) {
            POW10[i] = POW10[i - 1] * 10;
        }
    }

    public long totalWaviness(long num1, long num2) {
        return waveCount(num2) - waveCount(num1 - 1);
    }

    private long waveCount(long num) {
        if (num < 100) return 0;
        long total = 0;
        for (int p : WAVES) {
            total += countWays(num, p);
        }
        return total;
    }

    private long countWays(long num, int pattern) {
        String s = Long.toString(num);
        int n = s.length();
        int t = pattern < 100 ? 1 : 0;
        long count = 0;

        for (int i = 0; i < n - 2; i++) {
            long pre = (i == 0) ? 0 : Long.parseLong(s.substring(0, i));
            long cur = Long.parseLong(s.substring(i, i + 3));
            long suf = (i + 3 == n) ? 0 : Long.parseLong(s.substring(i + 3));
            long mult = POW10[n - i - 3];
            
            long ways = 0;
            long edge = 0;

            if (cur > pattern) {
                ways = pre - t + 1;
            } else if (cur == pattern) {
                ways = Math.max(0, pre - t);
                edge = (pre >= t) ? (suf + 1) : 0;
            } else { // cur < pattern
                ways = Math.max(0, pre - t);
            }

            count += ways * mult + edge;
        }

        return count;
    }
}