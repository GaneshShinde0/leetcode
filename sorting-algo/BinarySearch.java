class BinarySearch {
    //Binary Search
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return start;
    }
    public int searchInsertNaive(int[] nums, int target) {
        int start = 0, end=nums.length;
        if (target<=nums[0]) return 0;
        if (target>nums[nums.length-1]) return nums.length;
        int mid = (start+end)/2;
        while((end-start)>1){
            if(nums[mid]>target){
                end=mid;
            }else if (nums[mid]<target){
                start=mid;
            }else{
                return mid;
            }

            if ((end-start)==1) return end;
            
            // System.out.println("#############");
            // System.out.println(mid);
            // System.out.println(start);
            // System.out.println(end);
            mid = (start+end)/2;
        }
        return mid;
    }
}
