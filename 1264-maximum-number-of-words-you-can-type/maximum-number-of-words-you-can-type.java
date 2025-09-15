class Solution {
    public int canBeTypedWords1(String text, String brokenLetters) {
        String[] words = text.split("\s+");
        int res = 0;
        char[] chars = brokenLetters.toCharArray();
        for(int i=0;i<words.length;i++){
            for(char c:chars){
                if(words[i].indexOf(c)!=-1){
                    res++;
                    break;
                }
            }
        }
        return words.length-res;
    }
    
    public int canBeTypedWords(String text, String brokenLetters) {
        int res = 0;
        int n = text.length();
        int spaces = 0;
        char[] chars = brokenLetters.toCharArray();
        Set<Character> set= new HashSet<>();
        for(char c:chars) set.add(c);

        for(int i=0;i<n;i++){
            char curr = text.charAt(i);
            if(set.contains(curr)){
                res++;
                while(i<n && text.charAt(i)!=' ') i++;
            }
            if(i<n && text.charAt(i)==' ') spaces++;
        }
        return spaces+1-res;
    }
}