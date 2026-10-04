class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i]) && i-hm.get(nums[i])<=k) return true;
            hm.put(nums[i],i);
        }
        return false;
    }
    public boolean containsNearbyDuplicateVerySlow(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=i+k&&j<nums.length;j++){
                if (nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    HashSet<Integer> set = new HashSet<Integer>();
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        int ptr1 = 0;
        int ptr2 = Math.min(k, nums.length - 1);
        for (int i = ptr1; i <= ptr2; i++){
             if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        while (ptr2 < nums.length){
            set.remove(nums[ptr1]);
            ptr1++;
            ptr2++;
            if (ptr2 >= nums.length){
                break;
            }         
            if (set.contains(nums[ptr2])){
                return true;
            }
            set.add(nums[ptr2]);
        }
        return false;
    }
}