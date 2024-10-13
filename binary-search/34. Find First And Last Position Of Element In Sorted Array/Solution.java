class Solution {
    public int[] searchRangeInitialSolution(int[] nums, int target) {
        int start =0, end = nums.length-1;
        int n= nums.length;
        if(n==0) return new int[]{-1,-1};
        while(start<end){
            int mid = start+(end-start)/2; // Avoids overflow
            if(nums[mid]==target){ 
                start = mid;
                end = mid;
            }else if(nums[mid]>target){
                end = mid-1;
            }else start = mid+1;
        }
        while(end+1<nums.length && nums[end+1]==target){
            end++;
        }
        while(start>0 && nums[start-1]==target){
            start--;
        }
        // System.out.println("Start: "+start+"End: "+end);
        if(start>=0 && end>=0 && end <nums.length && nums[start]==nums[end] && nums[start]==target) return new int[]{start, end};
        return new int[]{-1,-1};
    }


    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    // Binary search for the first occurrence
    private int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                index = mid;
                end = mid - 1; // Continue searching in the left half
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }

    // Binary search for the last occurrence
    private int findLast(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                index = mid;
                start = mid + 1; // Continue searching in the right half
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }
}
