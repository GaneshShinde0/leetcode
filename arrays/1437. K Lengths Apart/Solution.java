class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i=0;
        int curr=-1;
        while(curr==-1 && i<nums.length){
            if(nums[i]==1) {
                curr=i;
                break;
            }
            i++;
        }
        i=i+1;
        for(;i<nums.length;i++){
            if(nums[i]==1){
                if((i-curr)<=k) return false;
                curr=i;
            }
        }
        return true;
    }

    // Alternate
    public boolean kLengthApartAlternate(int[] nums, int k) {
        int lastOneIndex = -1; // Store the index of the last seen '1'
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastOneIndex != -1) { // Check if this is not the first '1' encountered
                    if (i - lastOneIndex - 1 < k) { // Check if the distance is less than k
                        return false;
                    }
                }
                lastOneIndex = i; // Update the last seen '1' index
            }
        }
        return true; // If no violations are found, return true
    }
}
