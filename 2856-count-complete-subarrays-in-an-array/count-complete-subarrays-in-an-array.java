class Solution {
    public int countCompleteSubarraysNxN(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums) set.add(i);
        int dist = set.size(), n = nums.length, res = 0;
        for(int i=0;i<n;i++){
            Set<Integer> set2 = new HashSet<>();
            for(int j=i;j<n;j++){
                set2.add(nums[j]);
                if(set2.size()==dist) res++;
            }
        }
        return res;
    }

    public int countCompleteSubarrays(int[] nums){
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = nums.length, right = 0;
        int dist = new HashSet<>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new))).size();
        
        for(int left = 0; left<n; left++){
            if(left>0){
                int remove = nums[left-1];
                cnt.put(remove,cnt.get(remove)-1);
                if(cnt.get(remove)==0) cnt.remove(remove);
            }
            while(right<n && cnt.size()<dist){
                int add = nums[right];
                cnt.put(add, cnt.getOrDefault(add,0)+1);
                right++;
            }
            if(cnt.size()==dist){
                res+=(n-right+1);
            }
        }
        return res;
    }
}