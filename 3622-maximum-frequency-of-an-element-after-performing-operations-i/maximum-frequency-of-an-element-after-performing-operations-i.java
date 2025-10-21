// class Solution {
//     public int maxFrequency(int[] nums, int k, int numOperations) {
//         Arrays.sort(nums);
//         int left = 0, n = nums.length, right = 0;
//         int res = 0;
//         for(;right<n;right++){
//             int temp = numOperations;
//             while(temp>0 && left <=right && (nums[right]-nums[left])>k){
//                 left++;
//                 temp--;
//             }
//             res = Math.max(right-left+1,res);
//         }
//         return res;
//     }
// }

class Solution {
    public int maxFrequency(int[] nums, int k, int numOps){
        int maxVal = Arrays.stream(nums).max().getAsInt()+k+2;
        int[] count = new int[maxVal];

        for(int i:nums) count[i]++;
        for(int i=1;i<maxVal;i++) count[i]+=count[i-1];

        int res = 0;
        for(int i=0;i<maxVal;i++){
            int left = Math.max(0,i-k);
            int right = Math.min(maxVal-1,i+k);
            int total = count[right] - (left > 0 ? count[left - 1] : 0);
            int freq = count[i] - (i > 0 ? count[i - 1] : 0);
            res = Math.max(res,freq+Math.min(numOps,total-freq));
        }
        return res;
    }
}