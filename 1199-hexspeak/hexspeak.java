import java.math.BigInteger;

class Solution {
    public String toHexspeak(String num) {
        String s = Long.toHexString(Long.parseLong(num));
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='0'){
                sb.append('O');
            }else if (c=='1'){
                sb.append('I');
            }else if(Character.isDigit(c)){
                return "ERROR";
            }else{
                sb.append(c);
            }
        }
        return sb.toString().toUpperCase();
    }
    public static String stringToHex(String numStr) {
        BigInteger num = new BigInteger(numStr);
        return num.toString(16).toUpperCase();
    }
}