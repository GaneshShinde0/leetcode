class Solution {
    public String arrangeWordsUsingJavasStableSort(String text) {
        String[] arr = text.split(" ");
        final String temp = text;
        Arrays.sort(arr,(a,b)->{
            return Integer.compare(a.length(), b.length());
        });
        String res = String.join(" ",arr);
        return res.substring(0,1).toUpperCase()+res.substring(1).toLowerCase();
    }
    // Custom class to store the word and its original position
    class Word {
        String text;
        int index;
        
        Word(String text, int index) {
            this.text = text;
            this.index = index;
        }
    }

    public String arrangeWords(String text) {
        String[] rawWords = text.split(" ");
        Word[] words = new Word[rawWords.length];
        
        // Bind each word with its original index
        for (int i = 0; i < rawWords.length; i++) {
            words[i] = new Word(rawWords[i], i);
        }
        
        // Sort by length, then by original index
        Arrays.sort(words, (a, b) -> {
            if (a.text.length() == b.text.length()) {
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(a.text.length(), b.text.length());
        });
        
        // Reconstruct the sentence using a StringBuilder for efficiency
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i].text.toLowerCase());
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        
        // Capitalize the first letter
        String res = sb.toString();
        return Character.toUpperCase(res.charAt(0)) + res.substring(1);
    }
}