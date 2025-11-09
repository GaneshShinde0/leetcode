/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int searchInitial(ArrayReader reader, int target) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int mid = 0;
        while(low<high){
            mid = low+(high-low)/2;
            int curr = reader.get(mid);
            if(curr>target){
                high= mid; // If I do high = mid-1, it will not work properly because of integer division for mid.
            }else if(curr<target){
                low=mid+1; // we we increase low then atleast we get proper division.
                // Example low = 5, high = 6
                // If we increase low by 1 next time we get mid = 6... that is not case with decrementing high
            }else if (curr==target){
                return mid;
            }
        }
        return -1;
    }

    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int mid = 0;
        while(low<high){
            mid = low+(high-low)/2;
            int curr = reader.get(mid);
            if(curr>=target){
                high= mid;
            }else{
                low=mid+1;
            }
        }
        return reader.get(low)==target?low:-1;
    }
}