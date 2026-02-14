class Solution {
    public int maximumMatchingIndices(int[] nums1, int[] nums2) {
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
}