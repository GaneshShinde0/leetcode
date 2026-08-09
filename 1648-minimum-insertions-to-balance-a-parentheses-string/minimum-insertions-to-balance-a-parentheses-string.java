class Solution {
    public int minInsertions(String s) {
        int res = 0;   // Tracks the total number of insertions made
        int right = 0; // Tracks the number of right parentheses ')' currently needed

        for(char c : s.toCharArray()) {
            if(c == '(') {
                // If we currently need an odd number of ')', it means we have a single ')' 
                // without its required pair. Since a new '(' is starting, we must close 
                // the previous group by inserting one ')'.
                if(right % 2 == 1) {
                    right--; // We fulfill one ')' requirement by inserting it
                    res++;   // Increment the insertion count
                }
                // Every '(' requires two ')' to balance it
                right += 2;
            } else {
                // We encountered a ')', so we need one less ')'
                right--;
                
                // If right becomes negative, it means we have a ')' but no preceding '('
                if(right < 0) {
                    // We must insert a '(' before this ')'. 
                    // A new '(' requires two ')'. We already have the current ')', 
                    // so we still need exactly 1 more ')'. (-1 + 2 = 1)
                    right += 2; 
                    res++; // Increment the insertion count for the newly added '('
                }
            }
        }
        // Return the insertions already made + any remaining ')' we still need to add at the end
        return right + res;
    }
}