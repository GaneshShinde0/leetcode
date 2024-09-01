class Solution {
    // This method calculates the sum of the digits of a substring directly.
    int sumDigits(String sub) {
        int sum = 0;
        for (char ch : sub.toCharArray()) {
            sum += ch - '0'; // Convert character to its numeric value and add to sum
        }
        return sum;
    }
    
    public String digitSum(String s, int k) {
        // Base case: if the string length is less than or equal to k, return the string.
        if (s.length() <= k) {
            return s;
        }
        
        StringBuilder res = new StringBuilder();
        int l = s.length();
        int i = 0;
        
        // Process the string in chunks of size k
        while (i < l) {
            // Create a substring of size k or less if near the end of the string
            String sub = s.substring(i, Math.min(i + k, l));
            
            // Sum the digits of the substring
            int sum = sumDigits(sub);
            
            // Append the sum to the result string
            res.append(sum);
            
            // Move the index forward by k
            i += k;
        }
        
        // Recursively call the method with the new string
        return digitSum(res.toString(), k);
    }
}
