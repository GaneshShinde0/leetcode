class DetectCapital {

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

    // Optimized Solution
    public boolean detectCapitalUse0ms(String word) {
        char firstChar = word.charAt(0);
        int wordLen = word.length();
        int smallCount =0; 
        int capitalCount = 0;


        for(int i=0;i<wordLen;i++){
            firstChar = word.charAt(i);
            if(firstChar>='a' && firstChar<='z') smallCount ++;
            else capitalCount ++;
        }
     
        if(capitalCount ==wordLen || smallCount==wordLen) return true;
        firstChar = word.charAt(0);

    
        if(capitalCount==1 && (firstChar>='A' && firstChar<='Z')) return true;


        return false;
    }
}
