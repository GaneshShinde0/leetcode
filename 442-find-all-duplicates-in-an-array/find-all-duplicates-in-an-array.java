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
        // 1<=x<=8
        for(int i=0;i<n;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0) li.add(index+1);
            nums[index]=-nums[index];

            // if(nums[i]>0){
            //     nums[nums[i]-1] = -nums[nums[i]-1];
            // }
            // if(nums[nums[i]-1]<0) {
            //     li.add(-nums[nums[i]-1]);
            //     continue;
            // }
        }
        return li;
    }
}