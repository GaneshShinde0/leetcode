class Solution {
    public int validSubarrays(int[] nums) {
        int res = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!stk.isEmpty() && nums[i]<nums[stk.peek()]){
                res+=(i-stk.pop());
            }
            stk.push(i);
        }

        while(!stk.isEmpty()){
            res+=nums.length-stk.pop();
        }
        return res;
    }
}