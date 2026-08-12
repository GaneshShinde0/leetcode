/*
Intuition And Algorithm:
Problem Statement: If the XOR of the entrie array is 0, then Alice wins.

If the XOR condition is never triggered, then clearly Alice wins iff there are even number of elements, as every player has a move.

Actually, Alice always has a move when there are even number of elements... If Xor is not zero, but there are no possible moves then 0xor S !=0 , causes a contradition.

Similarly if there are an odd number of elements, then Bob always faces an even number of elements and has a move, so the answer is just the parity of the number of elemnts in the array.



*/

class Solution {
    public boolean xorGame(int[] nums) {
        int x = 0;
        for(int num:nums) x ^=num;
        return nums.length%2==0||x==0;
    }
}