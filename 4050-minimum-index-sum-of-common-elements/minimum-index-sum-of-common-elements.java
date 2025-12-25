class Solution {
    public int minimumSum(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> numIndex = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;

        for(int i = 0; i < nums1.length; i++){
            if(!numIndex.containsKey(nums1[i])) { //We will consider first index only (As question asks us to get minimum index sum i+j) considering first will guarantee minimum
                numIndex.put(nums1[i], i);
            } 
        }

        for(int i = 0; i < nums2.length; i++) {
            if(numIndex.containsKey(nums2[i])){
                minIndex = Math.min(numIndex.get(nums2[i]) + i, minIndex);
            }
        }

        if(minIndex ==  Integer.MAX_VALUE){ // If no minimum index has been seen
            return -1;
        }

        return minIndex;
    }
}