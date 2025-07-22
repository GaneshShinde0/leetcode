class Solution {
    public int maximumUniqueSubarrayDoesNotWork(int[] nums) {
        int res = nums[0],temp=0;
        int[] cumSum = new int[nums.length];
        int[] lastIndex = new int[10001];
        cumSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            cumSum[i] = cumSum[i-1]+nums[i];
        }
        lastIndex[nums[0]]=1;
        temp = nums[0];
        int beg =0;
        System.out.println(Arrays.toString(cumSum));
        for(int i=1; i<nums.length;i++){
            if(lastIndex[nums[i]]!=0 && lastIndex[nums[i]]>beg){
                beg = i;
                temp = cumSum[i]-cumSum[lastIndex[nums[i]]-1];
                res = Math.max(res,temp);
            }else{
                temp+=nums[i];
            }
            res = Math.max(res,temp);
            lastIndex[nums[i]]=i+1;
            System.out.println(Arrays.toString(lastIndex));
            System.out.println("RES: "+res+", TEMP: "+temp);
        }
        return res;
    }

    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Set<Integer> seen = new HashSet<>();
        int maxSum = 0, currSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // If nums[right] is duplicate, shrink window from left
            while (seen.contains(nums[right])) {
                currSum -= nums[left];
                seen.remove(nums[left]);
                left++;
            }
            // Expand window
            seen.add(nums[right]);
            currSum += nums[right];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}