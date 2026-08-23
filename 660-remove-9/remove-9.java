/*
Until 10 -> 9
Until 100 -> 80
*/

class SolutionUsingBuiltInFunction {
    public int newInteger(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }
}

class Solution {
    public int newInteger(int n) {
        int ans = 0;
        int placeValue = 1; // Represents the 1s, 10s, 100s position in our final decimal number
        
        while (n > 0) {
            // Get the current base-9 digit
            int digit = n % 9;
            
            // Place it in the correct position of our result
            ans += digit * placeValue;
            
            // Move to the next digit
            n /= 9;
            placeValue *= 10;
        }
        
        return ans;
    }
}