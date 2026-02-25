/*
"010110"

011111 => Two Flips

000111 => Two Flips.

Number of ones to left 
[0,1,1,2,3,3]

Number of zeros to right 
[3,2,2,1,1,1]

Ones:   [0,1,1,2,3,3]
Zeros:  [3,2,2,1,1,1]

*/

class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int result = n;
        int[] ones = new int[n];
        int curr = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1') curr++;
            ones[i]=curr;
        }
        curr = 0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0') curr++; // Zeros on the right
            int temp = curr+ones[i]-1; // Zeros on right + ones on left - 1 (minus 1 is for reducing the current)
            result = Math.min(result,temp);
        }
        return result;
    }
}