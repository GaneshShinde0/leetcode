class Solution {
    public int minInsertions(String s) {
        int res = 0, right = 0;
        for(char c: s.toCharArray()){
            if(c=='('){
                if(right%2>0){
                    right--;
                    res++;
                }
                right+=2;
            }else{
                right--;
                if(right<0){
                    right+=2;
                    res++;
                }
            }
        }
        return right+res;
    }
}