/*
Input: nums = [2,1,3], k = 4
Kth Smallest SubArray Sum.


- Sorting Wont work-> Will Mess up the order.
- Brute force might work but too slow.
- HashMap, TreeMap wont work too slow.

- PrefixSum -> Might-> Lets try
[2, 3, 6]
- PrefixSum + Binary Search on Ans?
- Low = min(arr), high = sum(arr)

*/
class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).sum();
        int n = nums.length;
        while(low<high){
            int m = (low+high)/2, floor = 0, sum = 0;
            for(int left = 0, right= 0;right<n;){
                if(sum + nums[right]<=m){
                    sum += nums[right++];
                    floor += right-left;
                }else{
                    sum -= nums[left++];
                }
            }
            if(floor<k) low = m+1;
            else high = m;
        }
        return low;
    }
}