class Solution {
    public int minInsertions(String s) {
        int res = 0, right = 0; // Result and Rights needed
        for(char c:s.toCharArray()){
            if(c=='('){
                right+=2; // Every new '(' requires exactly two ')''
                if(right%2==1){ //If there's an unmatched single ')', insert one ')' to complete the pair
                    right--; // Deduct one from needed ')' since we just inserted it
                    res++; // Increment the insertion counter
                }
            }else{ // When we see ')'
                right--; // we need one less right
                if(right<0){ // If right is negative, we have a ')' without preceding '('
                    right+=2; // Insert a '('  (which requires two ')', balancing out to +1)
                    res++; // Increment the insersion counter for new '('
                }
            }
        }
        return res+right;
    }
}