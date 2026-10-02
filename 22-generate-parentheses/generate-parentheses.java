class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recurse(0,0,n,result,new StringBuilder());
        return result;
    }
    private void recurse(int open, int close, int n, List<String> result, StringBuilder sb){
        if((sb.length()==n*2)){
            result.add(sb.toString());
            return;
        }else{
            if(open>close){
                sb.append(")");
                recurse(open,close+1,n,result,sb);
                sb.deleteCharAt(sb.length()-1);
            }
            if(open<n){
                sb.append("(");
                recurse(open+1,close,n,result,sb);
                sb.deleteCharAt(sb.length()-1);
            }
            
            
        }
    }
}