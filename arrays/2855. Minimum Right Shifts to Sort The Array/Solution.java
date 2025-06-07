class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int ind = 0, c =0;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i-1)>nums.get(i)){
                ind = i;
                c++;
            }
        }
        if(c>1) return -1;
        if(ind == 0) return 0;// Array is already properly sorted.
        return nums.get(nums.size()-1)>nums.get(0)?-1:nums.size()-ind; // Return -1 if last element is greater than first, else return index where array should have been started.
    }
}
