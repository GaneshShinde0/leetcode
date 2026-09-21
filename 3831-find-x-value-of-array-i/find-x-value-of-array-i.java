/*
Approach: Dynamic Programming:
Intuition:
We use nums[i,j] to denote the subarray [nums[i],nums[i+1],…,nums[j]]. In particular, when i>j, the subarray is defined to be empty.

According to problem statement, we can remove any non-overlapping prefix and suffix of nums while keeping nums non-empty. The remaining elements form a non-empty subarray nums[i,j].

Furthermore, there is one-to-one correspondence between different subarrays nums[i,j] and different valid operations. Specifically to obtain nums[i,j] we can only perform the following operation:

- Remove the prefix nums[0,i-1] and the suffix nums[j+1, n-1].

Therefore, problem asks us to count nummber of subarrays in nums whose product has remainder x when divided by k.

## Dynamic Programming:
Define dp[i][r] as the number of non-empty subarrays ending at index i whose product of elements has raminder r when divided by k. Initially, all states are 0.

When considering index i, all non-empty subarrays ending at i come form two sources.
- A subarray of length 1 containing element nums[i];
- A new subarray obtained by appending the element nums[i] to the end of any non-empty subarray ending at i-1

For the first case, the product of the subarray modulo k is 
r = nums[i]%k;

So we have dp[i][r]+=1

For the second case, suppose the product of a subarray ending at i-1 has remainder r modulo k. After appending the element nums[i], the product of the new subarray modulo k becomes
(r*nums[i]) mod k.

Therefore, we obtain the state transition equation.
dp[i][(r*nums[i])%k] += dp[i-1][r], 0<=r<k

After ccompleting the state transitions for all indices i, we sum  dp[i][x] across all i to obtain the answer for each remainder x:

result[x] = sum(0...n-1 dp[i][x])

The space complexity of the dynamic programming method above is O(nk), wher en is the length of nums. Since the state transition depends on the state from previous layer we can use a rolling array to optimize the space complexty further to O(k).

*/
class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] res = new long[k];
        long[] dp = new long[k]; // Initial State: No elements have been proessed so no-non-empty sumbarray exists.
        
        for(int i=0;i<n;i++){
            long[] ndp = new long[k]; // current layer state => Rolling Array
            ndp[nums[i]%k]++;
            for(int r=0;r<k;r++){
                ndp[(int)(((long) r*nums[i])%k)] += dp[r]; //After appending the element nums[i], the product of the new subarray modulo k becomes (r*nums[i]) mod k.
            }
            dp = ndp;
            for(int r=0;r<k;r++){
                res[r] += dp[r];
            }
        }
        return res;
    }
}