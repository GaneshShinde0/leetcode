/*

1->1
9->9
10->1
11->0
12->1
13->1
14->1
15->2
19->4
20->1
29->9
30->2
31->0
50->3
51->0
90->5
91->0
190->1
191->0
192->0

*/
/*
Intuition:
Sequence of digits is formed by writing all numbers in order. We don't need to build the full string - Just locate the range (1 digit, 2 digit) where the nth digit lies and extract it.


Approach:
1. Start with 1 digit numbers (length = 1) which contribute 9 digits(1-9).
2. Subtract chunks until n fits within a digit-length block.
3. Once the digit range is found, calculate the exact number and digit within it.
*/
class Solution {
    public int findNthDigit(int n) {
        int i = 1;
        long count = 9;
        long start = 1;
        while(n>i*count){
            n-=i*count;
            i+=1;
            count*=10;
            start*=10;
        }
        long number = start + (n-1)/i;
        return String.valueOf(number).charAt((n-1)%i)-'0';
    }
}