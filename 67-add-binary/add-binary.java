class Solution {
    public String addBinaryNotIdealForInputGreaterThan32(String a, String b){
        return Integer.toBinaryString(Integer.parseInt(a,2)+ Integer.parseInt(b,2));
    }

    public String addBinary(String a, String b){
        int n = a.length(), m = b.length();
        if(n<m) return addBinary(b,a);
        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m-1;
        for(int i=n-1;i>-1;i--){
            if(a.charAt(i)=='1') carry++;
            if(j>-1 && b.charAt(j--)=='1') ++carry;
            if(carry%2==1) sb.append('1');
            else sb.append('0');
            carry/=2;
        }
        if(carry%2==1) sb.append('1');
        sb.reverse();
        return sb.toString();
    }
    public String addBinaryI(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLen = a.length()-1, bLen = b.length()-1;
        int carry = 0;
        while(aLen>=0||bLen>=0){
            char aChar = aLen>=0?a.charAt(aLen):'0';
            char bChar = bLen>=0?b.charAt(bLen):'0';
            if(aChar=='1' && bChar=='1'&&carry==0){
                carry = 1;
                sb.insert(0, '0');
            }else if(aChar=='1' && bChar=='1' && carry==1){
                carry = 1;
                sb.insert(0,'1');
            }else if(carry==1 && (aChar=='1'||bChar=='1')){
                carry = 1;
                sb.insert(0,'0');
            }else if((aChar=='1'||bChar=='1')){
                carry = 0;
                sb.insert(0,'1');
            }else if(carry==1){
                sb.insert(0,'1');
                carry = 0;
            }else {
                sb.insert(0,'0');
            }
            aLen--;
            bLen--;
        }
        if(carry==1) sb.insert(0,'1');
        return sb.toString();
    }
}