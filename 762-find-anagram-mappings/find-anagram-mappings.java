class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> num2Idx = new HashMap<>();
        int n = nums1.length;
        for(int i=0;i<n;i++){
            num2Idx.put(nums2[i],i);
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i]=num2Idx.get(nums1[i]);
        }
        return res;
    }
}