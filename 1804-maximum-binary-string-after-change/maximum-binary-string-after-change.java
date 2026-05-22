class Solution {
    public String maximumBinaryString(String binary) {
        int zeros = 0, ones=0,n=binary.length();
        StringBuilder sb = new StringBuilder("1".repeat(n));
        for(char c: binary.toCharArray()){
            if(c=='0'){
                zeros++;
            }else if(zeros==0){
                ones++;
            }
        }
        if(ones<n) sb.setCharAt(ones+zeros-1,'0');
        return sb.toString();
    }
}