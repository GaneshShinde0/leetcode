class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split("\s+");
        HashMap<Character,String> cS = new HashMap<>();
        HashMap<String, Character> sC = new HashMap<>();
        if(arr.length!=pattern.length()) return false;
        for(int i=0;i<pattern.length();i++){
            char c= pattern.charAt(i);
            if(cS.containsKey(c) && !cS.get(c).equals(arr[i])) return false;
            if(sC.containsKey(arr[i]) && !sC.get(arr[i]).equals(c)) return false;
            cS.put(c,arr[i]);
            sC.put(arr[i],c);
        }
        return true;
    }

    public boolean wordPatternInitial(String pattern, String s) {
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