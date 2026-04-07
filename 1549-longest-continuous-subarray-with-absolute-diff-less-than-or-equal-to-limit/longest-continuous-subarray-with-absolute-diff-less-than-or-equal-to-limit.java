class Solution {
    public int longestSubarrayInitial(int[] nums, int limit) {
        int left = 0, n = nums.length;
        int result = 1;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int right = 0; right < n; right++) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            Map.Entry<Integer, Integer> last = treeMap.lastEntry();
            Map.Entry<Integer, Integer> first = treeMap.firstEntry();
            if (last.getKey() - first.getKey() > limit) {
                treeMap.put(nums[left], treeMap.getOrDefault(nums[left], 0) - 1);
                if (treeMap.get(nums[left]) == 0)
                    treeMap.remove(nums[left]);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public int longestSubarray(int[] nums, int limit){
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int left = 0, n = nums.length;
        int result = 1;
        for(int right = 0; right < nums.length; right++){
            while(!maxDeque.isEmpty() && maxDeque.peekLast()<nums[right]) maxDeque.pollLast();
            maxDeque.offerLast(nums[right]);

            while(!minDeque.isEmpty() && minDeque.peekLast()>nums[right]) minDeque.pollLast();
            minDeque.offerLast(nums[right]);

            while(maxDeque.peekFirst() - minDeque.peekFirst() > limit){
                if(maxDeque.peekFirst() == nums[left]) maxDeque.pollFirst();
                if(minDeque.peekFirst() == nums[left]) minDeque.pollFirst();
                left++;
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}