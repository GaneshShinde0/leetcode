class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int i = digits.length-1;
        while(carry==1&&i>=0){
            if(carry==1){
                carry = (digits[i]+1)/10;
                digits[i]=(digits[i]+1)%10;
            }else{
                break;
            }
            i--;
        }
        if(carry==0){
            return digits;
        }else{
            int[] res = new int[digits.length+1];
            res[0]=carry;
            // for(i=0;i<digits.length;i++){
            //     res[i+1]=digits[i];
            // }
            return res;
        }
    }
}