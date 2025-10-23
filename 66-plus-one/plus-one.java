class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        for(int i=n-1;i>=0;i--){
            if((digits[i]+carry)==10){
                carry = 1;
                digits[i]=0;
            }else{
                digits[i]+=carry;
                carry = 0;
            }
        }
        if(carry==1){
            int[] res = new int[n+1];
            res[0]=carry;
            return res;
        }else{
            return digits;
        }
    }
}