class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i=0; i<s.length();i++){
            if(i-j>1&&s.charAt(i)==sb.charAt(i-j-1)&&sb.charAt(i-j-1)==sb.charAt(i-j-2)){
                j++;
                continue;
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}