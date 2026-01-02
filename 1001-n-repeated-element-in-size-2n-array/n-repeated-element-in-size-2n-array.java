class Solution {
    public int repeatedNTimes1(int[] nums) {
        int[] freq = new int[10001];
        for(int i:nums){
            freq[i]++;
            if(freq[i]>1)return i;
        }
        return -1;
    }
    public int repeatedNTimes(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i:nums)
        {
            if(!s.add(i))
              return i;
        }
        return nums[nums.length-1];
    }
}