class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()>12) return result;
        backtrack(s,0,0,new StringBuilder(),result);
        return result;
    }
    public void backtrack(String s, int i, int dots, StringBuilder sb, List<String> result){
        if(dots==4 && i==s.length()){
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        if(dots>=4) return;
        for(int j=i;j<Math.min(s.length(),i+3);j++){
            int curr = Integer.parseInt(s.substring(i,j+1));
            if(curr<256 && (i==j || s.charAt(i)!='0')){
                int start = sb.length();
                sb.append(s.substring(i,j+1)).append(".");
                backtrack(s,j+1,dots+1,sb,result);
                sb.delete(start,sb.length());
            }
        }
    }
}