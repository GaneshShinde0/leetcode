class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> li, int k) {
        
        int[] nums = new int[li.size()];
        for(int i=0;i<li.size();i++){
            nums[i]=li.get(i);
        }
        int left = 1, right = nums.length;
        while(left<right){
            boolean increasingOne = false;
            boolean increasingTwo = false;
            int temp = k-1;
            while(left<right){
                if(nums[left-1]<nums[left]){
                    temp--;
                    left++;
                }else{
                    break;
                }
            }
            if(temp<=-k) return true;

            if (temp<=0) increasingOne = true;
            temp = k-1;
            left++;
            if(!increasingOne)continue;
            while(left<right&&temp>0){
                if(nums[left-1]<nums[left]){
                    temp--;
                    left++;
                }else{
                    break;
                }
            }
            left++;
            if (temp==0) increasingTwo = true;
            if(increasingOne==increasingTwo && increasingOne == true) return true;
        }
        return false;
    }
}