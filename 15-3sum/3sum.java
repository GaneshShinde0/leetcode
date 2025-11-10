class Solution {
    public List<List<Integer>> threeSumGivesMemoryLimitExceeded(int[] nums) {
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i+1;j<n;j++){
                if(set.contains(-(nums[j]+nums[i]))){
                    List<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[j]);
                    li.add(-(nums[j]+nums[i]));
                    res.add(li);
                }
                set.add(nums[j]);
            }
        }
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> finalRes = new ArrayList<>();
        for(List<Integer> li:res){
            Collections.sort(li);
            if(!set.contains(li)){
                finalRes.add(new ArrayList<>(li));
            }
            set.add(new ArrayList<>(li));
            li.clear();
        }
        return finalRes;
    }

    // TLE 314/315
    public List<List<Integer>> threeSum(int[] nums){
        Map<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i],i);
        }
        Set<List<Integer>> result = new HashSet<>();
        if(n<3) return new ArrayList<>(result);

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = -(nums[i]+nums[j]);
                int idx = hm.getOrDefault(temp,0);
                if(hm.containsKey(temp) && i!=idx && j!=idx){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], temp);
                    Collections.sort(triplet);
                    if(!result.contains(triplet)) result.add(triplet);
                }
            }
        }
        return new ArrayList<>(result);
    }
    public List<List<Integer>> threeSum2(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 &&nums[i]==nums[i-1]) continue;
            int left= i+1, right = n-1;
            while(left<right){
                int threeSum = nums[i]+nums[left]+nums[right];
                if(threeSum>0) right--;
                else if(threeSum<0) left++;
                else{
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while(nums[left]==nums[left-1] && left<right){
                        left++;
                    }
                }
            }
        }
        return res;
    }
}