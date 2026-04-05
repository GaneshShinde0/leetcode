class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, element = nums[0];
        int[] temp = new int[10000000];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==element)count++;
            else{
                count--;
                if(count==0){
                    element = nums[i];
                    count = 1;
                }
            }
        }
        return element;
    }
}