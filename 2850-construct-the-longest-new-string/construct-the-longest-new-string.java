/*
X => "AA"
Y => "BB"
Z => "AB"

We can do following 
XYZ
ZXY
YZX

Assume we only have AA and BB.

- If we have more AA than BB 
- we will put AABBAA...BBAA-> i.e. one more AA than BB
- So we will have Min(x,y+1) of AA

- If We have more BB than AA
- We will put BBAABB...AABB-> i.e. one more BB than AA
- So we will have min(x+1,y) of BB

- About AB. 
- as we have to find maximum possible length of new string, then AB will not have any effect.
- we can place AB anywhere like ABABAB and max length would still be same.
- And we can take all of them

- Sum up 3 parts * 2 (AB, AA, BB) (z,x,y) are of length 2
- we return (min(x, y + 1) + min(x + 1, y) + z) * 2
*/
class Solution {
    public int longestString(int x, int y, int z) {
        return (Math.min(x,y+1)+Math.min(x+1,y)+z)*2;
    }
}