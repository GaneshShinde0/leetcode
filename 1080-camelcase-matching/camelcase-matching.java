class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        int pLen = pattern.length();
        for(String query: queries){
            int queryPtr = 0, patternPtr = 0;
            boolean curr = false;
            for(;queryPtr<query.length();queryPtr++){
                char ch = query.charAt(queryPtr);
                char ph = pattern.charAt(Math.min(pLen-1,patternPtr));
                if(ch==ph){
                    patternPtr++;
                }else if('A'<= ch&& ch<='Z' && ch!=ph){
                    break;
                }
            }
            if(queryPtr == query.length() && pLen== patternPtr){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}