class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        if(s2.length()<s1.length()) return false;
        int[] s1chars = new int[26];
        int[] s2chars = new int[26];

        for(char c:s1.toCharArray()){
            s1chars[c-'a']++;
        }
        for(int i=0;i<s1.length();i++){
            s2chars[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<=s2.length()-k;i++){
            boolean check = check(s1chars,s2chars);
            if(check) return true;
            s2chars[s2.charAt(i)-'a']--;
            if(i<s2.length()-k) s2chars[s2.charAt(i+k)-'a']++;
        }
        return false;
    }

    public boolean check(int[] s1chars, int[] s2chars){
        for(int i=0;i<s1chars.length;i++){
            if(s1chars[i]!=s2chars[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusionModifiedForLoop(String s1, String s2) {
        int k = s1.length();
        if (s2.length() < k) return false;

        int[] s1chars = new int[26];  // Frequency array for s1
        int[] s2chars = new int[26];  // Sliding window frequency array for s2

        // Populate the frequency array for s1
        for (char c : s1.toCharArray()) {
            s1chars[c - 'a']++;
        }

        // Initialize the sliding window with the first 'k' characters of s2
        for (int i = 0; i < k; i++) {
            s2chars[s2.charAt(i) - 'a']++;
        }

        // Check the initial window
        if (check(s1chars, s2chars)) return true;

        // Slide the window across s2
        for (int i = k; i < s2.length(); i++) {
            // Slide the window: remove the character before the window and add the new one
            s2chars[s2.charAt(i - k) - 'a']--;  // Remove the leftmost character of the previous window
            s2chars[s2.charAt(i) - 'a']++;  // Add the new character at the right end of the window

            // Check if the current window matches s1's character frequencies
            if (check(s1chars, s2chars)) return true;
        }

        return false;  // No matching permutation found
    }
}
