class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int[] freq = new int[101];
        for(int num:nums){
            freq[num]++;
        }
        int idx = 0;
        for(int i=0;i<target;i++){
            idx+=freq[i];
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<freq[target];i++){
            res.add(idx++);
        }
        return res;
    }
}