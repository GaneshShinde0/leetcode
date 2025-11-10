/*
Minimum Operations to Convert all elements to Zero

What we can do 
    - If current is same as previous continue;
    - If current is 0 continue;

    - If we have not processed anything increase result by 1
    - If we have previous element greater than current... Then increase the result by 1... as we have processed larger element and we need to process (current -> smaller) element.
    - If we have previous element smaller than current element... we will think about processing current element.


*/
class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        for(int i:nums){
            while(!stk.isEmpty() && stk.peek()>i){
                stk.pop(); // As we had previously added elements and increased result... we have found one less element... We will have to remove them.
            }
            if(i==0) continue;
            if(stk.isEmpty()|| stk.peek()<i){
                stk.add(i);
                res++;
            }
        }
        return res;
    }
}