/*
Brute Force solution Check for XOR After Range Multiplication Queries II

Approach 2: Square Root Decomposition + Difference Array.
- We Observe that the step size k affects the complexity differently, so we divide the queries into two categories based on relationship between k and (n)^1/2, and handle each category separately.
    - When k>=(n)^1/2, each query touches at most (n/k)<=(n^1/2). Total Time complexity in this case is O(q*(n)^1/2)
    - When k<(n^1/2), a single query may access many elements, making the brute force approach inefficient.
For smaller step sizes (k<n^(1/2)), we group queries by their k value so that queries with same k can be processed together. The key observation is that indices affected by the same k form a fixed pattern. For example, when k =3, the affected indices are l,l+3, l+6,.... 

Once k is fixed, each query [l,r,v] multiplies elements at position l, l+k, l+2k, ... by v; this is equivalent to performing range multiplication on a subsequence defined by step size k.

To handle this efficiently, we use a difference array diff initialized with all values set to 1. For Query [l, r, v]. We determine the last affeccted index and denote the net Position as R. for example, in query [2,7,3], the last affected indiex is 5 so R = 8, we then apply
- diff[l] =diff[l]*v
- diff[R] = diff[R]*v^-1

Here v^-1 is the modular inverse of v under M = 10^9+7, which can be computed using Fermat's Little Theorem as v^M-1. Each query is processed in O(log M) time.

After processing all queries for a fixed K, we traverse teh difference array and compute prefix products:
diff[i] = diff[i]*diff[i-k]

This gives the cumulative multiplier for each position. We then apply these values back to the original array in O(n) time.

The total time complexity for handling queries with small step sizes is O(n^3/2+qlogM)

Finally, we need to compute R. The last affected index is l+[(r-l)/k+1]*k
The maximum posible value of R is n+k. For conveniencce, we use a difference array of size n+T.
*/

class Solution {
    private static final int MOD = 1_000_000_007;

    private int pow(long x, long y){
        long res = 1;
        while(y>0){
            if((y&1)==1){
                res = (res*x)%MOD;
            }
            x = (x*x)%MOD;
            y>>=1;
        }
        return (int) res;
    }
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int root = (int) Math.sqrt(n);
        List<List<int[]>> groups = new ArrayList<>(root);
        for(int i=0;i<root;i++){
            groups.add(new ArrayList<>());
        }
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];
            if(k<root){
                groups.get(k).add(new int[]{l,r,v});
            }else{
                for(int j=l;j<=r;j+=k){
                    nums[j] = (int) ((1l*nums[j]*v)%MOD);
                }
            }
        }
        long[] diff = new long[n+root];
        for(int k = 1; k<root;k++){
            if(groups.get(k).isEmpty()) continue;
            Arrays.fill(diff,1);
            for(int[] q: groups.get(k)){
                int l = q[0];
                int r = q[1];
                int v = q[2];
                diff[l] = (diff[l]*v)%MOD;
                int R = ((r-l)/k+1)*k+l;
                diff[R]= (diff[R]* pow(v,MOD-2))%MOD;
            }
            for(int i=k;i<n;i++){
                diff[i] = (diff[i]*diff[i-k])%MOD;
            }
            for(int i=0;i<n;i++){
                nums[i] = (int)((1l*nums[i]*diff[i])%MOD);
            }
        }
        int result = 0;
        for(int num:nums){
            result^=num;
        }
        return result;
    }
}