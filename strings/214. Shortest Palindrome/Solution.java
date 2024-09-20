class Solution {

    // Naive solution for this will be check if string is palindrome;
    // int i = s.length()-1
    // while(!palindrome(s.substring(0,i))){
    //    i--;
    //}
    // return s.substring(0,i)+s;
    public String shortestPalindromeNaive(String s) {
        if(s.length()<2) return s;
        int i = s.length();
        while(!isPalindrome(s.substring(0,i))){
            i--;
        }
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().substring(0,s.length()-i)+s;
    }
    public boolean isPalindrome(String s){
        int l = s.length()-1;
        for(int i=0;i<(l/2)+1;i++){
            if(s.charAt(i)!=s.charAt(l-i)) return false;
        }
        return true;
    }

    public String shortestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }

        // Find the longest palindromic prefix
        int left = 0;
        for (int right = length - 1; right >= 0; right--) {
            if (s.charAt(right) == s.charAt(left)) {
                left++;
            }
        }

        // If the whole string is a palindrome, return the original string
        if (left == length) {
            return s;
        }

        // Extract the suffix that is not part of the palindromic prefix
        String nonPalindromeSuffix = s.substring(left);
        StringBuilder reverseSuffix = new StringBuilder(
            nonPalindromeSuffix
        ).reverse();
        // Form the shortest palindrome by prepending the reversed suffix
        return reverseSuffix
            .append(shortestPalindrome(s.substring(0, left)))
            .append(nonPalindromeSuffix)
            .toString();
    }
}
