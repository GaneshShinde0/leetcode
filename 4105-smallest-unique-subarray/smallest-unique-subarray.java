/*
## Intuition
- Combine binary search with the sliding window and rolling hash technique.

## Explaination:
- It searches for the minimum subarray length by testing lengths from left = 1 to right = n
- For a given length k, it calculates the rolling hash of every subarray of length k.
- These hash values are stored in hashmap to count how many times each subarray appears.
- If atlest one hash  has a frequency of 1, it means a unique subarray of length k exists.
- Then it searches for a smaller valid length.
- Otherwise, it increases the search length.

## Complexity
Time: O(nlogn)
Space: O(n)

Using the Rabin-Karp rolling hash allows computing the next hash in O(1) time.
*/
class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        long b = 131;
        long mod = 1l<<31 -1;
        int l=1, r = n;
        while(l<r){
            int k = (l+r)/2;
            long h = 0, p = 1;
            for(int i=0;i<k;i++){
                h = (h*b+nums[i])%mod;
                p = (p*b)%mod;
            }
            HashMap<Long, Integer> c = new HashMap<>();
            c.put(h,1);
            for(int i=k;i<n;i++){
                h = (h*b+nums[i]-(nums[i-k]*p)%mod)%mod;
                if(h<0) h += mod;
                c.put(h,c.getOrDefault(h,0)+1);
            }
            boolean found = false;
            for(int val: c.values()){
                if(val==1){
                    found = true;
                    break;
                }
            }
            if(found){
                r=k;
            }else{
                l = k+1;
            }
        }
        return l;
    }
}