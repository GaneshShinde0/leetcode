class Solution {
    public int minTimeToType(String word) {
        int res =Math.min(word.charAt(0)-'a',('z'-word.charAt(0)+1))+word.length();
        for(int i=1;i<word.length();i++){
            res+=Math.min(Math.abs(word.charAt(i)-word.charAt(i-1)),26-Math.abs((word.charAt(i-1)-word.charAt(i))));
        }
        return res;
    }

     public int minTimeToTypeRefactored(String word) {
        // Calculate the time to move to the first letter and press it.
        int res = Math.min(word.charAt(0) - 'a', 'z' - word.charAt(0) + 1) + word.length();
        
        for (int i = 1; i < word.length(); i++) {
            // Clockwise distance
            int clockwise = Math.abs(word.charAt(i) - word.charAt(i - 1));
            // Counterclockwise distance
            int counterclockwise = 26 - clockwise;
            // Add the minimum of both distances
            res += Math.min(clockwise, counterclockwise);
        }
        
        return res;
    }
}
