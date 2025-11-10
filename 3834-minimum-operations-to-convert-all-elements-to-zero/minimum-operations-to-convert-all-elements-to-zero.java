class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        for(int i:nums){
            while(!stk.isEmpty()&&stk.peek()>i){
                stk.pop();
            }
            if(i==0) continue;
            if(stk.isEmpty() ||stk.peek()<i){
                res++;
                stk.add(i);
            }
        }
        return res;
    }
}