class Solution {
    public int countPrimesBruteForce(int n) {
        boolean[] isNumPrime = new boolean[n];
        Arrays.fill(isNumPrime,true);
        int res =0;
        for(int i=0;i<n;i++){
            if(isPrime(i)) res++;
        }
        return res;
    }
    private boolean isPrime(int num){
        if(num<2) return false;
        if(num==2) return true;
        if(num%2==0) return false;
        for(int i=3;i<=Math.sqrt(num);i+=2){
            if(num%i==0) return false;
        }
        return true;
    }

    /*
    Sieve of Eratosthenes
    To count number of prime numbers less than n, we can use the Sieve of Eratoshtenes, 
    a well known algorithm that efficiently identifies all prime numbers upto a given number.
    The key idea is to iteratively mark the multiples of each prime number starting from 2 as non-prime
    */
    /*
    Approach
    1. Create a boolean array isPrime of size n and initialize all entries as true, except for index 0 and 1 which are not primes.
    2. Iterate from 2 to sqrt(n). For every number i:
        If isPrime[i] is true, mark all multiples of i starting from i*i as false; (as we have already marked (i*(<i)) as false in earlier steps).
    3. Count the number of true entries in isPrime array  from index 2 to n-1;
    */

    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        int res=0;
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<n;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        for(boolean b:isPrime){
            if(b) res++;
        }
        return res;
    }



}