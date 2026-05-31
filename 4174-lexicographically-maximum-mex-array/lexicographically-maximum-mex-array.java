/*
- You are given an integer array nums.
- You want to construct an array result by repeatedly performing the following operation until nums becomes empty.
    - Choose an integer k such that 1<=k<=len(nums)
    - Compute the MEX of the first K elements of nums.
    - Apend this MEX to result.
    - Remove the first k elements from nums.
Return the lexicographically minimum array result that can be obtained after performing the operations.
The MEX if an array is the smallest non-negative integer not present in the array.
An array a is lexicographically greater than an array b if in the first position where a and b differe, array a has an element that is greater than the corresponding element in b. If the first min(a.length, b.length) elements do not differe, then longer array is lexicographically greater one.

# Intuition:
- To make the resulting array lexicographically maximum, our greedy strategy should be to always extract the largest possible MEX for the current segment. The maximum MEX we can extract from index i onwards is equal to the MEX of the remaining suffix. SO if we precompute the suffix MEX, we know exactly what target value to build.

# Approach:
1. Precompute Suffix MEX: Iterate through the array from right to left. Use a set initialized with values 0 to n to keep track of missing numbers. As we encounter elements, we remove them from the set. The smallest remaining element (*s.begin()) is the MEX for that suffix, which we store in the sm array.
2. Greedy Prefix Construction: Iterate from left to right. Set our target MEX v to sm[0].
3. initialize a new set st with numbers form 0 to v. This set tracks the numbers we still need to see to achieve our target MEX v.
4. As we traverse, we remove the current element a[i] from st. If the smallest remaining element in st becomes >=v, it means we have successfully found all numbers from 0 to v-1.
5. We immediately cut the array, append our found MEX to the result, clear st, and update our target v to the suffix MEX of the next segment (sm[i+1]).
*/
class Solution {
    public int[] maximumMEX(int[] nums) {
        int n = nums.length;
        int[] sm = new int[n];
        // Suffix MEX Precomputation
        TreeSet<Integer> s = new TreeSet<>();
        for(int i=0;i<=n;i++){
            s.add(i);
        }
        // Smallest remaining element is the MEX for SUFFIX.
        for(int i=n-1;i>=0;i--){
            s.remove(nums[i]);
            sm[i]=s.first();
        }
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> set =  new TreeSet<>();
        int v = sm[0];
        for(int i=0;i<=v;i++){
            set.add(i);
        }
        for(int i=0;i<n;i++){
            set.remove(nums[i]);
            // Safe dereference: If a set is empty, all needed numbers are found.
            int p = set.isEmpty()?v:set.first();
            if(p>=v){
                ans.add(p);
                set.clear();
                if(i<n-1){
                    v = sm[i+1];
                    for(int k=0;k<=v;k++){
                        set.add(k);
                    }
                }
            }
        }
        
        return getArrayFromList(ans);
    }

    private int[] getArrayFromList(List<Integer> ans){
        int[] result = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}