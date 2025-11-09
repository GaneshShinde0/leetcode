/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int mid = 0;
        while(low<high){
            mid = low+(high-low)/2;
            int curr = reader.get(mid);
            if(curr>target){
                high= mid;
            }else if(curr<target){
                low=mid+1;
            }else if (curr==target){
                return mid;
            }
        }
        return reader.get(mid-1)==target?mid-1:-1;
    }
}