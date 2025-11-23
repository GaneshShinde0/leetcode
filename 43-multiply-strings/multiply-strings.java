class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        for(int i=num2.length()-1;i>=0;i--){
            StringBuilder sb = new StringBuilder();
            sb.append("0".repeat(num2.length()-1-i));
            int mult1 = num2.charAt(i)-'0';
            int carry = 0;
            for(int j=num1.length()-1;j>=0;j--){
                int mult2 = num1.charAt(j) -'0';
                int mult = mult1*mult2+carry;
                sb.insert(0,mult%10);
                carry = mult/10;
            }
            if(carry>0) sb.insert(0,carry);
            // System.out.println(sb);
            StringBuilder sum = new StringBuilder();
            if(i<num2.length()-1){
                carry = 0;
                res.insert(0,"0".repeat(sb.length()-res.length()));
                for(int k=sb.length()-1;k>=0;k--){
                    int op1 = sb.charAt(k)-'0';
                    int op2 = res.charAt(k)-'0';
                    sum.insert(0,(op1+op2+carry)%10);
                    carry = (op1+op2+carry)/10;
                }
                if(carry>0)sum.insert(0,carry);
                res = sum;
            }else{
                res = sb;
            }
            // System.out.println(sum);
        }
        int index = 0;
        while (res.length() > 1 && res.charAt(index) == '0') {
            res.deleteCharAt(index); // Delete the leading '0'
        }
        return res.toString();
    }
}