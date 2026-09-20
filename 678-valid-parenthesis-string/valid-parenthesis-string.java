class Solution {
    public boolean checkValidString(String s) {
        int minOpen= 0, maxOpen = 0;
        for(char c:s.toCharArray()){
            if(c=='*'){
                maxOpen++;
                minOpen--;
            }else if(c=='('){
                maxOpen++;
                minOpen++;
            }else{
                maxOpen--;
                minOpen--;
            }
            if(maxOpen<0) return false;
            minOpen = Math.max(minOpen,0);
        }
        return minOpen==0;
    }
}