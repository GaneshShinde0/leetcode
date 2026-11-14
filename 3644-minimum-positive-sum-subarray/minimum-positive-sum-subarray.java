class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] prefix = new int[nums.size()+1];
        int min = Integer.MAX_VALUE;
        prefix[0] = 0;
        
        for(int i = 1; i <= nums.size(); i ++){
            prefix[i] += prefix[i-1] + nums.get(i-1);
        }

        for(int length = l; length <= r; length++){
            for(int i = 0; i <= nums.size() - length ; i++){
                if(prefix[i+length] - prefix[i] > 0) min = Math.min(min, prefix[i+length] - prefix[i]);
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}