class Solution {
    public int minimumOperationsInitial(int[] nums) {
        int count = 0;
        int currSub = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=currSub){
                currSub = nums[i];
                count++;
            }
        }
        return count;
    }
    public int minimumOperations(int[] nums) {
        int[] x=new int[101];
        int count =0;
        for (int i=0; i<nums.length; i++){
            int num = nums[i];
            if(num != 0 && x[num] == 0){ // x[num]==0 means we check if the element was previously substracted.
                x[num]= 1; // If the element was substracted we mark that as yes ... so that it will not come up in later subtractions
                count++;
            }
            
        }
        return (count);
    }

}