/*
modify function

op1 => set any index value to +1
op2 => Multiply by 2 for all elements in array.

Return minimum number of operations needed to get nums from empty array.



Intuition: Thought Process
Order of elements we perform operations does not matter. 
so 1,5 can be processed as 5,1
or
[4,2,5] can be processed as 
[2,4,5]

Maybe we will start will small number as the operations needed for small number will always be required for other numbers.

Example

for 2 we require 2 ops ...normalize on array
[0,2,3]
lets solve 2,3
2 will require again 2 ops .. normalize on array
[0,0,1]
1 require one operation 
total => 5

Lets solve for another example
1,5
ops for 1 , =>1
... We can generalize if i is multiple of 2 otherwise we cant.
*/
class Solution {
    public int minOperations(int[] nums) {
        int op1 = 0, op2 = 0;
        for(int num:nums){
            op1 += Integer.bitCount(num);
            op2 = Math.max(31-Integer.numberOfLeadingZeros(num),op2);
        }
        return op1+op2;
    }
}