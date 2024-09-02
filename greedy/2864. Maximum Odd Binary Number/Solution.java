class Solution {
    public String maximumOddBinaryNumberTakes5ms(String s) {
        int zeroCount = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') zeroCount++;
        }
        return "1".repeat(s.length() - zeroCount - 1) + "0".repeat(zeroCount) + "1";
    }

    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        
        // Count the number of '1's in the string
        for (char ch : s.toCharArray()) {
            if (ch == '1') count++;
        }
        
        int len = s.length();
        char[] arr = new char[len];

        // Initialize all elements of the array with '0'
        for (int i = 0; i < len; i++) {
            arr[i] = '0';
        }

        // Place the last '1' at the end to ensure the number is odd
        arr[len - 1] = '1';
        count--;
        
        // Fill the remaining '1's from the start of the array
        int i = 0;
        while (count-- > 0) {
            arr[i++] = '1';
        }

        // Convert the char array back to a String and return it
        return new String(arr);
    }
}
