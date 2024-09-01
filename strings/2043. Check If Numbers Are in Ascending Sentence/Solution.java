// Space Complexity: O(1)
// Time Complexity: O(n)
class Solution {
    public boolean areNumbersAscendingAlternate(String s) {
        int prev = Integer.MIN_VALUE;
        
        for(String token: s.split(" ")) {
            try {
                int number = Integer.parseInt(token);
                if(number <= prev)
                    return false;
                prev = number;
            }
            catch(Exception e) {}
        }
        
        return true;
    }

    public boolean areNumbersAscending(String s) {
        int previous = 0;
        
        for(String str: s.split(" "))
        {
            if(Character.isDigit(str.charAt(0)))
            {
                int number = Integer.parseInt(str);
                
                if(number <=previous)
                    return false;
                
                previous = number;
            }
        }
        return true;
    }
}
