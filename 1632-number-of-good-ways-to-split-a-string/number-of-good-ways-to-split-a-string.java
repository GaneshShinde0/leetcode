class Solution {
    public int numSplitsInitial(String s) {
        int[] freqLeft = new int[26];
        int[] freqRight = new int[26];
        int count =0;
        for(int i=0;i<s.length();i++){
            freqRight[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            freqLeft[s.charAt(i)-'a']++;
            freqRight[s.charAt(i)-'a']--;
            if(areDistinct(freqLeft,freqRight)) count++;
        }
        return count;
    }

    private boolean areDistinct(int[] a, int[] b){
        int left =0, right = 0;
        for(int i=0;i<a.length;i++){
           if(a[i]>0) left++;
           if(b[i]>0) right++;
        }
        return left==right;
    }

    // Optimal
    public int numSplits(String s) {
        int n = s.length();
        
        // Frequency of characters on right side initially (whole string)
        int[] freqRight = new int[26];
        for (char c : s.toCharArray()) {
            freqRight[c - 'a']++;
        }

        // Track distinct counts
        int leftDistinct = 0, rightDistinct = 0;
        for (int f : freqRight) if (f > 0) rightDistinct++;

        int[] freqLeft = new int[26];
        int count = 0;

        // Try splits between i and i+1
        for (int i = 0; i < n - 1; i++) {
            char c = s.charAt(i);

            // Move c from right → left
            if (freqLeft[c - 'a'] == 0) leftDistinct++;
            freqLeft[c - 'a']++;

            freqRight[c - 'a']--;
            if (freqRight[c - 'a'] == 0) rightDistinct--;

            // Compare distinct counts
            if (leftDistinct == rightDistinct) count++;
        }

        return count;
    }
}