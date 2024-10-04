class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        Arrays.sort(words, (word1,word2)-> (word1.charAt(word1.length()-1))-(word2.charAt(word2.length()-1)));
        for(String word:words){
            sb.append(word.substring(0,word.length()-1));
            sb.append(" ");
        }
        String ans = sb.toString();
        return ans.substring(0,ans.length()-1);
    }

    public String sortSentenceOptimized(String s) {
        String[] str = s.split(" ");
        StringBuilder ans = new StringBuilder();
        String[] sorted = new String[str.length];

        for (int i = 0; i < str.length; i++) {
            for (char c : str[i].toCharArray()) {
                if (Character.isDigit(c)) {
                    int pos = c - '0';  // Convert the character digit to integer
                    sorted[pos - 1] = str[i].substring(0, str[i].length() - 1); // Store the word without the digit
                    break;  // Break after finding the digit
                }
            }
        }

        // Build the final sorted sentence
        for (int i = 0; i < sorted.length; i++) {
            ans.append(sorted[i]);
            if (i != sorted.length - 1) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}
