class Solution {
    public String shiftingLettersTLE(String s, int[][] shifts) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] arr = new int[n];
        for(int i=0;i<shifts.length;i++){
            for(int j=shifts[i][0];j<=shifts[i][1];j++){
                if(shifts[i][2]==1){
                    arr[j]++;
                }else{
                    arr[j]--;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            chars[i]=(char) ('a'+(chars[i]-'a'+arr[i]%26+26)%26);
        }
        return String.valueOf(chars);
    }

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffArray = new int[n]; // Initialize a difference array with all elements set to 0.

        // Process each shift operation
        for (int[] shift : shifts) {
            if (shift[2] == 1) { // If direction is forward (1)
                diffArray[shift[0]]++; // Increment at the start index
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]--; // Decrement at the end+1 index
                }
            } else { // If direction is backward (0)
                diffArray[shift[0]]--; // Decrement at the start index
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]++; // Increment at the end+1 index
                }
            }
        }

        StringBuilder result = new StringBuilder(s);
        int numberOfShifts = 0;

        // Apply the shifts to the string
        for (int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + diffArray[i]) % 26; // Update cumulative shifts, keeping within the alphabet range
            if (numberOfShifts < 0) numberOfShifts += 26; // Ensure non-negative shifts

            // Calculate the new character by shifting `s[i]`
            char shiftedChar = (char) ('a' +
                ((s.charAt(i) - 'a' + numberOfShifts) % 26));
            result.setCharAt(i, shiftedChar);
        }
        return result.toString();
    }
}
