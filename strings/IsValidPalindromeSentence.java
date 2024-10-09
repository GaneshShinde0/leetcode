class IsValidPalindromeSentence {
    public boolean isPalindrome3Ms(String s) {
        // Convert string to lowercase
        s = s.toLowerCase();
        
        // Initialize two pointers
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Move the left pointer until it points to an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move the right pointer until it points to an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Check if the characters are equal
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            // Move both pointers inward
            left++;
            right--;
        }
        
        return true;
    }


     public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j) {
            char iChar = s.charAt(i);
            char jChar = s.charAt(j);
            if(!isValid(iChar)) { i++; }
            else if (!isValid(jChar)) {j--; }
            else if(lower(iChar) != lower(jChar)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    boolean isValid(char c) {
        return (c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9');
    }

    char lower(char c) {
        if(c>='A' && c<='Z') { return (char)(c+32) ;}
        return c;
    }
}
