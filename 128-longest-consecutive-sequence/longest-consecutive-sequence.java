class Solution {
    public int longestConsecutiveONLogN(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i:nums) set.add(i);
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            int localLength=1;
            while(set.contains(curr+1)){
                set.remove(curr);
                curr++;
                localLength++;
            }
            res = Math.max(res, localLength);
        }
        return res;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}