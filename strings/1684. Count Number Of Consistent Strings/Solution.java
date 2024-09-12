class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] freq = new int[26];
        int count=0;
        for(String word:words){
            int j=0;
            for(char i:word.toCharArray()){
                if(allowed.indexOf(i)==-1) break;
                j++;
            }
            if(word.length()==j) count++;
        }
        return count;
    }

    public int countConsistentStringsOptimized(String allowed, String[] words) {
        boolean[] s = new boolean[26];
        for (char c : allowed.toCharArray()) {
            s[c - 'a'] = true;
        }
        int ans = 0;
        for (String w : words) {
            if (check(w, s)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean check(String w, boolean[] s) {
        for (int i = 0; i < w.length(); ++i) {
            if (!s[w.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }
}
