/*
Super Ugly Numbers are positive integers whose prime factors are limited to a given list. We can build them by multiplying existing ugly numbers with given primes. Similar to merging k sorted lists.

Use an array ugly to store the sequence.
Maintain pointers (idx) and candidate values (val) for each prime. 
In each iteration, choose the minimum from val, append it and update corresponding indexes and values. 
This ensures we always pick the smallest new number and avoid duplicates.

Complexity:
Time : O(n*k) - Where K is the number of primes.
Space: O(n+k) - For the ugly, idx and val arrays
*/

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] ugly = new long[n]; // N Ugly Number
        ugly[0] = 1; // 
        int[] idx = new int[primes.length]; // Pointer per prime, all start at 0.
        long[] val = new long[primes.length]; // Candidate value per prime, initially primes[j]*ugly[0].
        for(int i=0;i<primes.length;i++) val[i] = primes[i];
        for(int i=1;i<n;i++){
            long min = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                if(val[j]<min){
                    min = val[j];
                }
            }
            ugly[i] = min; // Minimum of all values we curently have.
            for(int j=0;j<primes.length;j++){
                if(val[j] ==min){
                    idx[j]+=1;
                    val[j] = ugly[idx[j]]*primes[j];
                }
            }
            
        }
        return (int) ugly[n-1];

    }
}