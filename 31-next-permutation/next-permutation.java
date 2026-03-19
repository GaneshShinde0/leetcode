/*
input:[3 1 2]

All Permutations
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1

input: [3 1 2] 
output: [3 2 1]

input: [3 2 1]
output: [1 2 3]

Brute Force Solution:
    1. Generate All Permutations
    2. Linear Search
    3. Return Next.
Time Complexity: O(n!)
Input size is of 100, Brute force is not possible.

Better Solution:
In C++ STL library there is next_permutation function, it will automatically permute array and give us next permutation.

Example:
arr = [2 1 5 4 3 0 0]
next permutation (Swapping last 2)
[2 1 5 3 4 0 0] <smaller
[2 1 5 0 0 4 3] <smaller
[2 1 5 0 4 3 0] <smaller
[2 1 5 4 0 0 3] <smaller 

But we need greater.
2 5 4 3 1 0 0 > greater
2 4 5 3 1 0 0 > greater

Are they one step greater than current.
- We need one ste greater than current
    - So we will have to find element which is slightly lesser than its right (And from last)
    - This way we will be able to find something which we can change position for.

In this case: 2 1 5 4 3 0 0 ; element which is slightly lower than its right is 1 => its index 1

Now we have to find something which is slighly greater than it  (or just greater than 1)
- If we look at array => 3 is slightly greater than 1.

-- We do this just to make sure we are returning smallest greater (i.e. next permutation)
We got.
2 3 

We are remaining with 
    - 5 4 1 0 0 
We have to place remaining in sorted order
    - 0 0 1 4 5

Example 2:
1 2 3 4 5
Next Permutation
1 2 3 5 4.
Algorithm:
1. Find out index which is slightly lesser than its right.
2.1. If we dont find any element from 1 (that is array  is strictly decreasing) [3 2 1]
    - We Reverse the  array.
2.2. If index1 is there.
    - start from all the way back to find slightly greater.
    - Swap that with index1
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, index1 = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index1 = i;
                break;
            }
        }
        if(index1==-1){
            reverse(nums,0);
        }else{
            for(int i=n-1;i>=0;i--){
                if(nums[i]>nums[index1]){
                    swap(nums,i,index1);
                    reverse(nums,index1+1);
                    break;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private void reverse(int[] nums, int start){
        int ptr = nums.length-1;
        while(start<ptr){
            swap(nums, start, ptr);
            ptr--;
            start++;
        }
    }
}