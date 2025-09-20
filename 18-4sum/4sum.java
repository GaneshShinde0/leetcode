class Solution {
    // O(N^3xlog(m))
    public List<List<Integer>> fourSumONNN(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Long> hashSet = new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long fourth = (long)target-nums[i]-nums[j]-nums[k];
                    if(hashSet.contains(fourth)){
                        List<Integer> curr = Arrays.asList(nums[i],nums[j],nums[k],(int)fourth);
                        Collections.sort(curr);
                        set.add(curr);
                    }
                    hashSet.add((long)nums[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j= i+1;j<n;j++){
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l){
                    long sum = (long) nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        set.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }else if(sum<target) k++;
                    else l--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}