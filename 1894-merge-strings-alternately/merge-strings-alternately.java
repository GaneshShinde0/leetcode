class Solution {
    // Original Solution
    // Time Complexity: O(n), where n = max(word1.length(), word2.length())
    // Space Complexity: O(n) for StringBuilder and char arrays.
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length(), min = Math.min(m,n);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<min;i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(word1.length()>word2.length()){
            sb.append(word1.substring(min));
        }else{
            sb.append(word2.substring(min));
        }
        return sb.toString();
    }

    // Optimized Solution
    // Time Complexity: O(n), where n = max(word1.length(), word2.length())
    // Space Complexity: O(n) for StringBuilder. No additional space for char arrays.
    public String mergeAlternatelyOptimized(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, n1 = word1.length(), n2 = word2.length();
        
        // Merge characters from both words alternately
        while (i < n1 && i < n2) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        
        // Append the remaining part of the longer word
        if (i < n1) {
            sb.append(word1.substring(i));
        } else if (i < n2) {
            sb.append(word2.substring(i));
        }
        
        return sb.toString();
    }
}