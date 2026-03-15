/*
You are given two 0-indexed binary strings s and target of the same length n. You can do the following operation on s any number of times:

Choose two different indices i and j where 0 <= i, j < n.
Simultaneously, replace s[i] with (s[i] OR s[j]) and s[j] with (s[i] XOR s[j]).
For example, if s = "0110", you can choose i = 0 and j = 2, then simultaneously replace s[0] with (s[0] OR s[2] = 0 OR 1 = 1), and s[2] with (s[0] XOR s[2] = 0 XOR 1 = 1), so we will have s = "1110".

Return true if you can make the string s equal to target, or false otherwise.

Basically If we have 


111111100 -> We can some how transfer it to 
    111111100 -> choose i= 0, j = 8
        s[0]=> s[0] or s[8] becomes 1
        s[8]=> s[0] xor s[8] becomes 1
        We got 111111101 
    Alternatively we can choose any two points i, j  where we have 1 and 1 , and transform then to 0,1 or 1, 0
    If we continue to do this we will get 000000001
For this we just need single 1 and we can transform string to zeros 0000...0001

If we have string with only zeros it will stay 0. as 
    0 or 0 => 0
    0 xor 0 => 0

So basically if source has 1 we can transform to 0001
If target has 1 we can transform to 0001

If only one of them has 1 we return false;
if both of them does not have 1 we return true;

i.e. 
*/

class Solution {
    public boolean makeStringsEqual(String s, String target) {
        boolean sourceHasOne = s.contains("1");
        boolean targetHashOne = target.contains("1");
        return sourceHasOne == targetHashOne;
    }
}