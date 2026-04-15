/*
4, 5
100
101

and => 100
or => 101

sum of and and or => 3 (Same as number of bits in both of them.)

1100101
1010101

AND => 1000101
OR  => 1110101
SUM OF(AND +OR) bits  =>  8, Same as that of sum of bits in both of them.


Formula by induction

AND => BITS IN A + BITS IN B - BITS IN (A OR B)
AND => SUM OF COMMON BITS.
OR =>  BITS IN A + BITS IN B - SUM OF COMMON BITS

AND+OR => BITS IN A + BITS IN B.

Their Sum => 
*/
class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums) set.add(i);
        int n = set.size();
        int[] bitCounts = new int[n];
        int i=0;
        for(int num:set){
            bitCounts[i]=Integer.bitCount(num);
            i++;
        }
        Arrays.sort(bitCounts);
        int l = 0, r = n-1;
        long res = 0;
        while(l<n && r>=0){
            if(bitCounts[l]+bitCounts[r]>=k){
                res+=(n-l);
                r--;
            }else{
                l++;
            }
        }
        return res;
    }
}