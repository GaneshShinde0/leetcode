/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */
/*
[46,46,46,46,46,46,46,46,46,46,46,46,46,46,46,46,46,46,46,46,57,46,46,46,46]
*/
class Solution {
    public int getIndex(ArrayReader reader) {
        int low = 0, high = reader.length()-1; 
        while(low<high){
            int mid = (low+high)/2;
            if((high-low)%2==0){
                int cmp = reader.compareSub(low,mid-1,mid+1,high);
                if(cmp==0) return mid;
                else if (cmp==1) high = mid-1;
                else low = mid+1;
            }else{
                int cmp = reader.compareSub(low,mid,mid+1,high);
                if(cmp==1){
                    high = mid;
                }else{
                    low = mid+1;
                }
            }
        }
        return low;
    }
}