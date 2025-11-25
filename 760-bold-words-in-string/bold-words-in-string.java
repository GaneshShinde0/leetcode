/*
Brute Force:
- Lets try to learn which letters end up bold, since resulting answer will just be the canonical one, we put bold tags around each group of bold letters.
- To do this, we'll check for all occurrences of each word and mark the corresponding letters bold.
- Lets work on first setting bold[i] = true iff the ith letter is bold. For each starting position i in S, for each word, if S[i] starts with word, well set the appropriate letters bold.
- Now we have correct start of bold, A letter in position i is the first bold letter of group if bold[i] && (i==0||!bold[i-1]), and is the last bold letter if bold[i] && (i==N-1||!bold[i+1]). Alternatively, we could use itertoolds.groupby in python.
- Once we know which letters are first and last bold letters of group, we know where to put <b> and </b> tag.
*/
class Solution {
    public String boldWords(String[] words, String s) {
        int N = s.length();
        boolean[] bold = new boolean[N];
        for(int i=0;i<N;i++){
            for(String word:words){
                search:{
                    for(int k=0;k<word.length();k++){
                        if(k+i>=N || s.charAt(k+i)!=word.charAt(k)) break search;
                    }
                    for(int j=i;j<i+word.length();++j){
                        bold[j] = true;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            if(bold[i] && (i==0||!bold[i-1])) sb.append("<b>");
            sb.append(s.charAt(i));
            if(bold[i] && (i==N-1||!bold[i+1])) sb.append("</b>");
        }
        return sb.toString();
    }
}