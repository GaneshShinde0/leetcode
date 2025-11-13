/*
For any array; How many total subarrays are there;
n of size 1
n-1 of size 2
n-3 of size 3
....

1 of size n

-> This counts to n*(n+1)/2

When a product of subarrays is odd?
-> When there is no even element.

To Count number of odd sub arrays we count total number of consecutive odd elements.
-> If we subtract them from total number of subsets we will get result;
*/

class Solution {
    public long evenProduct(int[] nums) {
        int n = nums.length;
        // If I do not add 1l in following statement the calculation wont work properly;
        long total_subs = 1l*n*(n+1)/2, odd_cnt = 0, odd_subs = 0;
        for(int num: nums){
            if(num%2==1) odd_cnt++;
            else odd_cnt = 0;
            odd_subs+=odd_cnt;
        }
        return total_subs - odd_subs;
    }
}

/*
1 0 1 1 -> 6 

1 0 1 0

For first 0 do n*(n-1)/2
for next 0 do, 
*/