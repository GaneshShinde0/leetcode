class Solution {
    public List<Integer> findDuplicatesNaive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> li = new ArrayList<>();

        for(int i:nums){
            if(set.contains(i)){
                li.add(i);
            }
            set.add(i);
        }
        return li;
    }
    // Optimized
    public List<Integer> findDuplicatesOptimized(int[] nums) {
        int[] freq = new int[nums.length+1];
        List<Integer> li = new ArrayList<>();

        for(int i:nums){
            freq[i]++;
            if(freq[i]>1) li.add(i);
        }
        return li;
    }
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            int temp = Math.abs(nums[i]);
            if(nums[temp-1]<0) li.add(temp);
            else nums[temp-1]= -nums[temp-1];
        }   
        return li;
    }
}