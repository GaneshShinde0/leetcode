/*

Intuition: Since we have to find contiguous subarray having maximum product then approach should be combination of followin three cases:

Case 1: All elements are positive: Then answer will be product of all.
Case 2: Array has both +ve and -ve
    1. If the number of negative elements is even then again answer will be complete array because on multiplying all the negative numbers it will become positive.
    2. The number of negative elements is odd then you have to remove just one negative element and for that you need to check subarray to get max product.
Case 3: Array also contains 0: Then there will not be much difference. Its just that your array will be divided into subarray around that 0.
    - As soon as product becomes 0 make it 1 for next iteration.
    - Now you will be searching new subarray and previous max will already be updated.
    - These cases are much clear in approach 3.    
*/

class Solution {
    public int maxProduct157of191(int[] nums) {
        int prod = 1;
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(prod==0&&nums[i]!=0){
                prod=nums[i];
            }else{
                prod = nums[i]*prod;
            }
            res = Math.max(prod,res);
        }
        return res==Integer.MIN_VALUE?0:res;
    }

    /*
    Approach 1 : For each index i keep updating the max and min. We are also keeping min because on multiplying with any negative number your min will become max and max will become min. So for every index i we will take max of (ith element prevMax*ith element, prevMin * ith Element).
    */
    public int maxProduct(int[] nums){
        int max = nums[0], min = nums[0], ans = nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = max; // Store max because before updating min, max will already be updated.
            max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]); // Takes care of negative
            min = Math.min(Math.min(temp*nums[i],min*nums[i]), nums[i]);

            if(max>ans) ans = max;
        }
        return ans;
    }
}