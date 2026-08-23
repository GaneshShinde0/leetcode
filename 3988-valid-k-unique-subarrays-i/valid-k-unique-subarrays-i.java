import java.util.*;

class Solution {
    int blockSize;

    // Class to represent a query
    class Query {
        int l, r, index;

        Query(int l, int r, int index) {
            this.l = l;
            this.r = r;
            this.index = index;
        }
    }

    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        // System.out.println(Arrays.toString(nums));
        // if(Arrays.toString(nums).equals("[1, 1, 1, 1, 2, 2]")) return new boolean[]{true,false, false, false};
        int n = nums.length;
        int q = queries.length;
        
        // Optimal block size for Mo's Algorithm is usually sqrt(N)
        blockSize = (int) Math.sqrt(n) + 1;

        Query[] qs = new Query[q];
        for (int i = 0; i < q; i++) {
            qs[i] = new Query(queries[i][0], queries[i][1], i);
        }

        // Sort queries: first by block of L, then by R (alternating direction for speed)
        Arrays.sort(qs, (a, b) -> {
            int blockA = a.l / blockSize;
            int blockB = b.l / blockSize;
            if (blockA != blockB) {
                return Integer.compare(blockA, blockB);
            }
            // Sort R ascending for even blocks, descending for odd blocks
            return (blockA % 2 == 1) ? Integer.compare(a.r, b.r) : Integer.compare(b.r, a.r);
        });

        boolean[] ans = new boolean[q];
        int[] freq = new int[100001];
        
        int distinct = 0;
        int oddCount = 0;

        // Sliding window pointers
        int currL = 0, currR = -1;

        for (Query query : qs) {
            int L = query.l;
            int R = query.r;

            // Expand window on the left
            while (currL > L) {
                currL--;
                int x = nums[currL];
                if (freq[x] == 0) distinct++;
                freq[x]++;
                if (freq[x] % 2 == 1) oddCount++;
                else oddCount--;
            }
            // Expand window on the right
            while (currR < R) {
                currR++;
                int x = nums[currR];
                if (freq[x] == 0) distinct++;
                freq[x]++;
                if (freq[x] % 2 == 1) oddCount++;
                else oddCount--;
            }
            // Shrink window from the left
            while (currL < L) {
                int x = nums[currL];
                freq[x]--;
                if (freq[x] == 0) distinct--;
                if (freq[x] % 2 == 1) oddCount++;
                else oddCount--;
                currL++;
            }
            // Shrink window from the right
            while (currR > R) {
                int x = nums[currR];
                freq[x]--;
                if (freq[x] == 0) distinct--;
                if (freq[x] % 2 == 1) oddCount++;
                else oddCount--;
                currR--;
            }
            
            int merovlanti = 0; 

            // Subarray is valid if exactly k distinct elements exist, and 0 elements have an odd frequency
            ans[query.index] = (distinct == k && oddCount == 0);
        }

        return ans;
    }
}