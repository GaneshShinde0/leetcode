class LongestCommonPrefixOfString {
    public String longestCommonPrefixNaive(String[] strs) {
        String pf="";
        int minLen=Integer.MAX_VALUE;
        for(String s:strs){
            if(s.length()<minLen) minLen=s.length();
        }
        for(int i=0;i<minLen;i++){
            char c=strs[0].charAt(i);
            for (String s:strs){
                if(s.charAt(i)!=c){
                    return pf;
                }
            }
            pf+=c;
        }
        return pf;
    }

    //Achieves same result as startsWith
    public String longestCommonPrefixUsingIndexOf(String[] strs) {
        if(strs == null && strs.length == 0) return " ";

        String prefix = strs[0];
        for(int i=0;i<strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
    //Starts With Is more readable and less complex
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
