class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0, open = 0, close = 0;
        for(char c:s.toCharArray()){
            if(c=='('){
                open++;
                res += close;
                close = 0;
            }else if (c==')'){
                open--;
                if(open<0){
                    res++;
                    open=0;
                }
            }
        }
        return res+Math.abs(open);
    }
}