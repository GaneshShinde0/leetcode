class Solution {
    public int numSplits(String s) {
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
}