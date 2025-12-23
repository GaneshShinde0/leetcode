class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int opens = 0;
        for(char c:s.toCharArray()){
            if(opens==0 && c==')') {
                continue;
            }
            if(c=='(') opens++;
            if(c==')') opens--;
            sb.append(c);
        }
        int i=sb.length()-1;
        while(i>=0 && opens>0){
            if(sb.charAt(i)=='('){
                opens--;
                sb.deleteCharAt(i);
            }
            i--;
        }
        return sb.toString();
    }
}