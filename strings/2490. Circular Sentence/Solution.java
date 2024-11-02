class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n=words.length;
        if(words[0].charAt(0)!=words[n-1].charAt(words[n-1].length()-1)) return false;
        for(int i=0;i<n-1;i++){
            if(words[i].charAt(words[i].length()-1)!=words[i+1].charAt(0)) return false;
        }
        return true;
    }

    public boolean isCircularSentenceAlternate(String s) {
        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;

        int k = s.indexOf(" ");
        if (k == -1)
            return true;

        while (k != -1) {
            if (s.charAt(k - 1) != s.charAt(k + 1)) {
                return false;
            }

            k = s.indexOf(" ", k+1);
        }
        return true;
    }
}
