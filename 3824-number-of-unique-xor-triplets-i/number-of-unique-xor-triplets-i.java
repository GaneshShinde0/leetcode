/*
Elements are until N, then the number of different XORs can be number that can be represented by number larger than that number which is slightly next to upper bound in 2's power.

Example :
if N = 5 then it will be 8 (0->7)
if N = 9 then answer will be 15 (0->8)
*/
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n<=2) return n;
        int numberOfBits = (int) Math.ceil(Math.log(n+1)/Math.log(2));
        return (int) (Math.pow(2, numberOfBits));
    }
}