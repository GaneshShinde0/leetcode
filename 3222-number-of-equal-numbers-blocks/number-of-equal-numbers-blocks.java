/**
 * Definition for BigArray.
 * class BigArray {
 *     public BigArray(int[] elements);
 *     public int at(long index);
 *     public long size();
 * }
 */
class Solution {
    public int countBlocks(BigArray nums) {
        Set<Integer> set = new HashSet<>();
        long size = nums.size();
        for(long i=0;i<size;i++){
            long mult = 2;
            long temp = i;
            while(i+mult<size && nums.at(i+mult)==nums.at(temp)){
                i = i+mult;
                mult *=2;
            }
            set.add(nums.at(i));
        }
        return set.size();
    }
}