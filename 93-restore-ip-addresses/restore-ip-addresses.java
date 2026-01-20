class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()>12) return result;
        backtrack(0,0,s, new StringBuilder(),result);
        return result;
    }

    private void backtrack(int i, int dots, String s, StringBuilder sb, List<String> result){
        if(dots==4 && i==s.length()){
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        if(dots>4) return;
        for(int j=i;j<Math.min(s.length(),i+3);j++){
            if(Integer.parseInt(s.substring(i,j+1))<256 && (i==j || s.charAt(i)!='0')){
                int start = sb.length();
                sb.append(s.substring(i,j+1)).append(".");
                backtrack(j+1,dots+1, s, sb, result);
                sb.delete(start,sb.length());
            }
        }
    }
}