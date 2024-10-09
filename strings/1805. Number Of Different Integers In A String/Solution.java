class Solution {
    public int numDifferentIntegers(String word) {
        word = word+"a";
        int i=0;
        int start =-1;
        Set<String> set = new HashSet<>();
        while(i<word.length()){
            if(start==-1 && word.charAt(i)>='0'&& word.charAt(i)<='9'){
                start = i;
            }else if(start!=-1 && word.charAt(i)>='a' && word.charAt(i)<='z'){
                set.add(trim(word.substring(start,i)));
                start = -1;
            }
            i++;
        }
        return set.size();
    }
    public String trim(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0') return s.substring(i);
        }
        return "0";
    }

    public int numDifferentIntegersAlternate(String word) {
        Set<String> uniqueIntegers = new HashSet<>();
        int length = word.length();
        int i = 0;
        
        // Iterate through the string
        while (i < length) {
            // Skip non-digit characters
            if (!Character.isDigit(word.charAt(i))) {
                i++;
                continue;
            }
            
            // Start of a number
            int start = i;
            
            // Skip all digits to find the end of the current number
            while (i < length && Character.isDigit(word.charAt(i))) {
                i++;
            }
            
            // Add the trimmed number (without leading zeros) to the set
            uniqueIntegers.add(trimLeadingZerosAlternate(word, start, i));
        }
        
        // Return the number of unique integers found
        return uniqueIntegers.size();
    }

    // Helper method to remove leading zeros efficiently without creating unnecessary substrings
    private String trimLeadingZerosAlternate(String word, int start, int end) {
        // Find the first non-zero digit
        while (start < end && word.charAt(start) == '0') {
            start++;
        }
        // If the entire number was zeros, return "0", otherwise return the trimmed substring
        return (start == end) ? "0" : word.substring(start, end);
    }
}
