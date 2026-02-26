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
                result++;
            }else{
                result+=2;
                carry=1;
            }
        }
        return result+carry;
    }
}