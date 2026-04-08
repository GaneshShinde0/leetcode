/*
[1,4,7,8,5]
[1,4,5,7,8]

current min = 1
current max = 7

result = 6

change  1 to 4

*/
class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if(n==3) return 0;
        Arrays.sort(nums);
        int max = Integer.MAX_VALUE;
        max = Math.min(max,Math.abs(nums[n-1]-nums[2]));
        max = Math.min(max,Math.abs(nums[n-2]-nums[1]));
        max = Math.min(max,Math.abs(nums[n-3]-nums[0]));
        return max;
    }
}

/*
 1 2 3 4 5 6
*/