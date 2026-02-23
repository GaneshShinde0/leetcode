
/*
Intuition
If 1 not in A, we return 1.
If 2 not in A, we return 2.


Explanation
If 1 not in A,
we return 1,
otherwise we can have x = 1.

If 2 not in A,
we return 2.
otherwise we can have x = 2.

Since we can have x = 1 and x = 2,
then we can have x = 1 | 2 = 3.

If 4 not in A,
we return 4,
otherwise we have x = 4

Since we can have x = 1 and x = 4, then we can have x = 1 | 4 = 5.
Since we can have x = 2 and x = 4, then we can have x = 2 | 4 = 6.
Since we can have x = 1,2,4, then we can have x = 1 | 2 | 4 = 7.

So we can find the rule here,
find out the minimum pow of 2,
which is not in A.

The process of prove is s
*/
class Solution {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i:nums){
            s.add(i);
        }
        int a = 1;
        // If set does not contain power of two then we will return that.
        // If power of two is present then we will check next power of two
        while(s.contains(a)){
            a= a<<1;
        }
        return a;
    }

    public int minImpossibleORAlternate(int[] nums) {
        int singleBitsFound = 0;
        for (int n : nums) {
            if ((n & (n - 1)) == 0) {
                singleBitsFound |= n;
            }
        }
        return 1 << Integer.numberOfTrailingZeros(singleBitsFound ^ Integer.MAX_VALUE);
    }
}