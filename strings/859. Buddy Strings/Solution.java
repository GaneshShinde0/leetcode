class Solution {
    public boolean buddyStringsInitial(String s, String goal) {
        int count=0;
        int[] flags = new int[26];
        int[] flags2 = new int[26];
        if(s.length()!=goal.length()) return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=goal.charAt(i)){
                count++;
                if(count>2) return false;
            }
            flags[s.charAt(i)-'a']++;
            flags2[goal.charAt(i)-'a']++;
        }
        int temp=0;
        for(int i=0;i<26;i++){
            if(flags[i]!=flags2[i]) return false;
        }
        for(int i=0;i<26;i++){
            if(flags[i]>=2) return true;
        }
        if(count==2) return true;
        return false;
    }

    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) return false;
        char[] c1 = s.toCharArray();
        char[] c2 = goal.toCharArray();
        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (char c : c1) {
                freq[c - 'a']++;
                if (freq[c - 'a'] > 1) return true;
            }
            return false;
        }
        int first = -1;
        int second = -1;
        for (int i = 0; i < n; i++) {
            if (c1[i] != c2[i]) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        return second != -1 && c1[first] == c2[second] && c1[second] == c2[first];
    }
}
