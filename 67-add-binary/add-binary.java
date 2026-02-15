class Solution {
    public String addBinary(String a, String b) {
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