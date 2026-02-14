class Solution {
    public int maximumMatchingIndicesInitial(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> shiftCount = new HashMap<>();
        int ans = 0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    int shift = (i-j+n)%n;
                    shiftCount.put(shift,shiftCount.getOrDefault(shift,0)+1);
                    ans = Math.max(ans, shiftCount.get(shift));
                }
            }
        }
        return ans;
    }

    public int maximumMatchingIndices(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // Map each value to a list of its indices in nums1
        Map<Integer, List<Integer>> valToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valToIndices.computeIfAbsent(nums1[i], k -> new ArrayList<>()).add(i);
        }

        // Use an array instead of a HashMap for shift counts (indices 0 to n-1)
        int[] shiftCount = new int[n];
        int maxMatches = 0;

        // Iterate through nums2 and calculate shifts only for matching values
        for (int j = 0; j < n; j++) {
            if (valToIndices.containsKey(nums2[j])) {
                for (int i : valToIndices.get(nums2[j])) {
                    int shift = (i - j + n) % n;
                    shiftCount[shift]++;
                    maxMatches = Math.max(maxMatches, shiftCount[shift]);
                }
            }
        }

        return maxMatches;
    }
}