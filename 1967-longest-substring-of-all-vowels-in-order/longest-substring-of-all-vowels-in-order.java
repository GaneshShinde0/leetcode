class Solution {
    public int longestBeautifulSubstring(String word) {
        int left  = 0, result = 0, n = word.length();
        String vowels = "aeiou";
        for(int right=0;right<n;right++){
            left = right;
            int j=0;
            for(;j<5;j++){
                if(right==n||word.charAt(right)!=vowels.charAt(j)) break;
                while(right<n && word.charAt(right)==vowels.charAt(j)){
                    right++;
                }
            }
            if(j==5) result = Math.max(right-left,result);
            if(left!=right) right--;
        }
        return result;
    }
}