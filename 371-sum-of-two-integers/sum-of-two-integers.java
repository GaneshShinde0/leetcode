/*
01
10

11

A&B = 0
A^B = 3

10
11
A+B = 5 => 101

A&B = 10
A^B = 01

20  => 10100
30  => 11110

50  =>110010

20&30 => 10100 =.20
20|30 => 11110
20^30 => 01010

left shift all
20&30 => 10100 => 
        101000
20|30 => 11110 => 
        111100
20^30 => 01010 => 
        010100

50    =>110010
*/
class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int answer = a^b;
            int carry = (a&b)<<1;
            a = answer;
            b = carry;
        }
        return a;
    }
}