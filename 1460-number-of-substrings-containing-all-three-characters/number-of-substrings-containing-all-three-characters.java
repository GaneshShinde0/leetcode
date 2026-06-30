class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int left = 0;
        int[] charCount = new int[3];
        int n = s.length();
        for(int right = 0; right<n; right++){
            charCount[s.charAt(right) - 'a']++;
            while(charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0){
                count += n - right;
                charCount[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return count;
    }
}