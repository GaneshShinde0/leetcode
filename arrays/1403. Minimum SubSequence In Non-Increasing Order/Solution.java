class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int sum=0;
        for(int i:nums) sum+=i;
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();
        int revSum=0;
        for(int i=nums.length-1;i>=0;i--){
            revSum-=nums[i];
            sum-=nums[i];
            res.add(nums[i]);
            if(revSum+sum<0) return res;
        }

        return res;
    }

    public List<Integer> minSubsequenceOptimized(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] freq = new int[101];
        int total = 0;
        for (int val : nums) {
            freq[val]++;
            total += val;
        }

        int subSeqSum = 0;
        for (int i = 100; i > 0; i--) {
            while (freq[i] > 0) {
                list.add(i);
                subSeqSum += i;
                freq[i]--;
                if (subSeqSum > total - subSeqSum) {
                    return list;
                }
            }
        }

        return list;
    }
}
