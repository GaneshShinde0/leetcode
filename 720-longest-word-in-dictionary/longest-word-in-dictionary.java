class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        // Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
        Set<String> set = new HashSet<>();
        set.add("");
        for(String w:words){
            if(set.contains(w.substring(0,w.length()-1))) set.add(w);
        }
        set.add("");
        int currLen = 0;
        String res = "";
        for(String word:words){
            currLen = word.length();
            // if(currLen==res.length() && (word.compareTo(res)>0)) continue;
            if(set.contains(word.substring(0,currLen-1))){
                if(currLen>res.length()||(word.length()==currLen && word.compareTo(res)<0)){
                    res = word;
                }
            } 
        }
        return res;
    }
}