/*
Intuition:

If nums is not sorted, there exists atleast one adjacent pair nums[i], nums[i+1] where nums[i]>nums[i+1]. To minimize the number of steps it is unnecessary to break down the smaller nubmer because it would only increase the number of replacement operations.

As we got the logic for handling adjacent unsorted pairs, the next question is the order in which we process nums. Here, we need to traverse in reverese order. The reason is that our replacement operations will only make the current nums[i] become two (or more) smaller numbers.

If we start from the end and move toward the beginning, we can ensure that the suffix array always remains sorted. This is because we are replacing nums[i] with smaller element, which will not disrupt the sorting structure of the suffix array.

On the contrary, if we start form beginning and replace larger elements with smaller elements, we might get smaller than current number.

Lets Minimize the nubmer of operations. When we reach nums[i] during the reverse traversal, if nums[i]>nums[i+1], how many smaler numbers should we break nums[i] into? Here are few options.
- Breaking nums[i] into many 1s, which would require too many operations.
- Breaking nums[i] accoring to the value of nums[i+1], which is the remainder of nums[i] divided by nums[i+1] becoming the new nums[i]. However, in some cases this method can result in a very small snums[i]. 

    Example. [7] will be replaced by [1,3,3]

We can use a method similar to above.
- If nums[i] is divisible by nums[i+1], we break nums[i] into multiple elements of value nums[i+1].
- If nums[i] is not divisible by nums[i+1], we break nums[i] into 
    numsElements = nums[i]/nums[i+1]+1 
    Sorted elemets, with tht esmallest element being nums[i+1]/nums_elements. For example nums[i]=7 and nums[i+1]=3, we replace 7 with [2,2,3] by two replacement operations instead of making [1,3,3] 

- Reason for this is that all future elements on the left will need to be less than or equal to the element we split into here. Thus we would prefer the larger 2 over smaller 1, So we have more options for future splits.

In Summary, we traverse nums in reverse and break down each nums[i] that violates the sorting order according to the approach mentioned above. We also accumulate the number of replaccement operations. It is important to note that when we break nums[i] into n elements, it acutally  requires n-1 steps.

- numElements = (nums[i]+nums[i+1]-1)/nums[i+1]. regardless of whether nums[i] is divisible by nums[i+1] or not, we will always obtain correct result.


Algorithm:
1. Set answer as 0, and set n as the length of nums.
2. Iterate over nums backward from nums[n-2], as we dont need to replace nums[n-1]
    - If nums[i]<=nums[i+1] move on to the next element nums[i-1].
    - If nums[i] is divisible by nums[i+1], break nums[i] into numsElements = nums[i]/nums[i+1] elements, Otherwise break nums[i] into numsElements= nums[i]/nums[i+1]+1 elements. THis requires numElements-1 replacement operations. Hence we increment ansser by numELements -1;
    - The largest possible nums[i] after the operations is nums[i]/numElements, update nums[i] as nums[i]/numElements;
3. Return answer

*/

class Solution {
    public long minimumReplacementAlternate(int[] nums) {
        long answer = 0;
        int n = nums.length;
        
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]) continue;
            int numElements = (nums[i]+nums[i+1]-1)/nums[i+1]; // It will make sure to take one less when nums[i] is divisible and perform normal operation when it is not divisible.
            answer +=numElements-1;
            nums[i]= nums[i]/numElements;
        }
        return answer;
    }

    public long minimumReplacement(int[] nums) {
        long answer = 0;
        int n = nums.length;
        
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]) continue;
            int numElements = 0;
            if(nums[i]%nums[i+1]==0) numElements =  nums[i]/nums[i+1]; 
            else numElements =  nums[i]/nums[i+1]+1; // Extra one is of remainder.
            answer +=numElements-1; // Answer is number of splits which is numElements -1;
            nums[i]= nums[i]/numElements;
        }
        return answer;
    }
}