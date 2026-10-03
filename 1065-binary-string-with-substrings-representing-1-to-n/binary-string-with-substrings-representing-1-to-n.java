class Solution {
    public boolean queryString(String s, int n) {
        if(n>maxFeasibleN(s.length())) return false;
        for(int i=n;i>n/2;i--){
            if(!s.contains(Integer.toBinaryString(i))) return false;
        }
        return true;
    }
    /**
    * Computes the tightest necessary upper bound on N such that
    * a string S of length L could still possibly satisfy:
    * "S contains binary representations of all integers from 1 to N".
    *
    * This is NOT a sufficient condition (it doesn't guarantee such S exists),
    * but it IS a valid necessary condition — meaning if N exceeds this value,
    * the answer is guaranteed to be false, so we can safely prune early.
    *
    * Derivation reminder:
    * - For a number N with bit-length k (2^(k-1) <= N < 2^k),
    *   all integers in (N/2, N] share the same leading bit,
    *   so their remaining (k-1) bits must all be DISTINCT.
    * - There are ceil(N/2) such numbers, each needing a unique
    *   continuous substring of length (k-1) inside S.
    * - A string of length L has only (L - (k-1) + 1) possible substring
    *   positions of length (k-1).
    * - So we need: ceil(N/2) <= L - k + 2  →  N <= 2 * (L - k + 2)
    */
    private long maxFeasibleN(int L) {
        long best = 0;

        // k represents the bit-length of N; realistically N <= 1e9 needs k <= ~30
        for (int k = 1; k <= 32; k++) {
            long lower = 1L << (k - 1);     // smallest N with this bit-length (2^(k-1))
            long upper = (1L << k) - 1;     // largest N with this bit-length (2^k - 1)
            long cap   = 2L * (L - k + 2);  // max N allowed by the necessary condition for this k

            // If even the smallest number in this bucket violates the condition,
            // no larger k will work either (cap shrinks, lower grows) — stop early.
            if (cap < lower) break;

            // The feasible max for this bucket is whichever is smaller:
            // the natural range limit, or the condition's cap.
            long feasibleMax = Math.min(upper, cap);
            best = Math.max(best, feasibleMax);
        }

        return best;
    }
    public boolean queryStringWorks(String s, int n) {
        for(int i=n;i>n/2;i--){
            if(!s.contains(Integer.toBinaryString(i))) return false;
        }
        return true;
    }
}