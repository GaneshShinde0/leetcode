class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
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
}