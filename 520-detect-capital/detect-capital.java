class Solution {

    // Naive Solution Which takes 1 ms
    public boolean detectCapitalUse(String word) {
        char[] s = word.toCharArray();        
        return isAllCap(s)||isAllSmall(s)||isFirstCap(word);
    }
    public boolean isAllCap(char[] s){
        for (char c:s){
            if(c>='A'&&c<='Z'){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isAllSmall(char[] s){
        for (char c:s){
            if(c>='a'&&c<='z'){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isFirstCap(String word){
        return isAllCap(word.substring(0,1).toCharArray())&&isAllSmall(word.substring(1).toCharArray());
    }
}