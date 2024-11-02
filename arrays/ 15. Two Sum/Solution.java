class Solution {
    // Takes 2500 ms
    public List<List<Integer>> threeSumInitialSolution(int[] nums) {
        Map<Integer,Integer> arr = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            arr.put(nums[i],i);
        }
        Set<List<Integer>> result = new HashSet<>();
        if (nums.length<3) return new ArrayList<>(result);
        for(int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                int temp =-(nums[i]+nums[j]);
                int idx = arr.getOrDefault(temp,0);
                if(arr.containsKey(temp)&&i!=idx &&j!=idx){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], temp);
                    Collections.sort(triplet);
                    if(!result.contains(triplet)) result.add(triplet);
                }
            }

        }
        return new ArrayList(result);
    }


    // Two Pointer Takes 28ms
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 &&nums[i]==nums[i-1]) continue;
            int left=i+1, right = n-1;
            while(left<right){
                int threeSum = nums[i]+nums[left]+nums[right];
                if(threeSum>0) right--;
                else if(threeSum<0) left++;
                else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left+=1;
                    while(nums[left]==nums[left-1]&&left<right){
                        left++;
                    }
                }
            }
        }
        return res;
    }

}
