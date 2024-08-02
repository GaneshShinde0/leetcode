class IndicesWithIndexAndValueDifference {
    public int[] findIndicesN(int[] nums, int idxDiff, int valDiff) {
        int n = nums.length, min = 0, max = 0;
        for (int i = idxDiff; i < n; i++) {
            if (nums[i - idxDiff] < nums[min]) {
                min = i - idxDiff;
            }
            if (nums[i - idxDiff] > nums[max]) {
                max = i - idxDiff;
            }
            if (nums[i] - nums[min] >= valDiff) {
                return new int[] { min, i };
            }
            if (nums[max] - nums[i] >= valDiff) {
                return new int[] { max, i };
            }
        }
        return new int[] { -1, -1 };
    }

  public int[] findIndicesNXN(int[] nums, int indexDifference, int valueDifference) {
        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<nums.length;j++){
                if(Math.abs(i-j)>=indexDifference&&Math.abs(nums[i]-nums[j])>=valueDifference){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }
}
