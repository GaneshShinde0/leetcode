class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> charToStr= new HashMap<>();
        HashMap<String, Character> strToChar= new HashMap<>();
        char[] pArr = pattern.toCharArray();
        String[] sArr = s.split(" ");
        if(pArr.length!=sArr.length) return false;
        for(int i=0;i<pArr.length;i++){
            if(!charToStr.containsKey(pArr[i])&& !strToChar.containsKey(sArr[i])){
                charToStr.put(pArr[i], sArr[i]);
                strToChar.put(sArr[i], pArr[i]);
            }else{
                if(!charToStr.containsKey(pArr[i])&& strToChar.containsKey(sArr[i])){
                    return false;
                }else if(charToStr.containsKey(pArr[i])&& !strToChar.containsKey(sArr[i])){
                    return false;
                }else{
                    boolean flag = charToStr.get(pArr[i]).equals(sArr[i]) && strToChar.get(sArr[i]).equals(pArr[i]) ;
                    if(!flag) return false;
                }
            }
        }
        return true;
    }
}