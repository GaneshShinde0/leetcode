class Solution {
    public int minInsertions(String s) {
        int res = 0, curr = 0;
        for(char c: s.toCharArray()){
            if(c=='('){
                if(curr%2>0){
                    curr--;
                    res++;
                }
                curr+=2;
            }else{
                curr--;
                if(curr<0){
                    curr+=2;
                    res++;
                }
            }
        }
        return curr+res;
    }
}