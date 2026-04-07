class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0, n = nums.length;
        int result = 1;
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int right=0;right<n;right++){
            treeMap.put(nums[right],treeMap.getOrDefault(nums[right],0)+1);
            Map.Entry<Integer,Integer> last = treeMap.lastEntry();
            Map.Entry<Integer,Integer> first = treeMap.firstEntry();
            if(last.getKey()-first.getKey()>limit){
                treeMap.put(nums[left],treeMap.getOrDefault(nums[left],0)-1);
                if(treeMap.get(nums[left])==0) treeMap.remove(nums[left]);
                left++;
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}