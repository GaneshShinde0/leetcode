class Solution {
    public int majorityElement(int[] nums) {
        int m1 =1, element = nums[0];
        for(int i=1;i<nums.length;i++){
            if(element == nums[i]) m1++;
            else{
                m1--;
                if(m1<=0){
                    element = nums[i];
                    m1=1;
                }
            }
        }
        return element;
    }
}