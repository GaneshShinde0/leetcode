class Solution {

    // 6 ms beats 49.30%
    public int[] findIntersectionValuesNaive(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i:nums1) set1.add(i);
        for(int i:nums2) set2.add(i);
        int count1=0,count2=0;
        for(int i:nums1){
            if(set2.contains(i))count1++;
        }
        for(int i:nums2){
            if(set1.contains(i))count2++;
        }

        return new int[]{count1,count2};
        
    }
    // time beats 100 %; space beats 69.16%
    public int[] findIntersectionValuesUsingIntArray(int[] nums1, int[] nums2) {
        int[] s1 = new int[101];
        int[] s2 = new int[101];

        // Populate the first array
        for (int x : nums1) {
            s1[x] = 1;
        }

        // Populate the second array
        for (int x : nums2) {
            s2[x] = 1;
        }

        // Create result array
        int[] ans = new int[2];

        // Count intersection elements from nums1 present in nums2
        for (int x : nums1) {
            ans[0] += s2[x];
        }

        // Count intersection elements from nums2 present in nums1
        for (int x : nums2) {
            ans[1] += s1[x];
        }

        return ans;
    }

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        boolean[] s1 = new boolean[101];
        boolean[] s2 = new boolean[101];

        // Populate the boolean array for nums1
        for (int x : nums1) {
            s1[x] = true;
        }

        // Populate the boolean array for nums2
        for (int x : nums2) {
            s2[x] = true;
        }

        // Create result array
        int[] ans = new int[2];

        // Count intersection elements from nums1 present in nums2
        for (int x : nums1) {
            if (s2[x]) {
                ans[0]++;
            }
        }

        // Count intersection elements from nums2 present in nums1
        for (int x : nums2) {
            if (s1[x]) {
                ans[1]++;
            }
        }

        return ans;
    }
}
