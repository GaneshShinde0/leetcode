/*
1101

1st Step : 1101,=> 1110
2nd Step : 1110 => 111
3rd Step : 111 => 1000


*/

class Solution {
    public int numSteps(String s) {
        int result = 0;
        int carry = 0;
        int n = s.length()-1;
        for(int i=n;i>0;i--){
            int curr = s.charAt(i)-'0'+carry;
            if(curr%2==0){
                result++; // +1 is for dividing carry.
            }else{
                // As current digit is one, we will have to add one to it.
                // eg. 100001 => 100010
                // Adding one is 1 step
                // After adding one we will have to divide the number 
                // That is one more step.
                // Total Two steps and, carry tells us that current digit (i th) was one in next steps (i-1 th) calculation.
                result+=2; 
                carry=1; // Reset Carry as current digit is 1.
            }
        }
        return result+carry;
    }
}