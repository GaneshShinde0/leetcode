/*
Elements are until N, then the number of different XORs can be number that can be represented by number larger than that number which is slightly next to upper bound in 2's power.

Example :
if N = 5 then it will be 8 (1->7) (XORs 0->7)
if N = 9 then answer will be 16 (1->9) (XORs 0->15)
*/
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        // Number of elements in array
        int n = nums.length;
        // If there are less than or equal to elements we will return the number of elements.
        if(n<=2) return n;
        // Next Bit that is possible e.g. 9-> 16-> 4
        int numberOfBits = (int) Math.ceil(Math.log(n+1)/Math.log(2));
        return (int) (Math.pow(2, numberOfBits));
    }
}