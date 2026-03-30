class Solution {
    public boolean checkStrings(String source, String target) {
        int[] checkEvenIndices = new int[26];
        int[] checkOddIndices = new int[26];
        for(int i=0;i<source.length();i++){
            int charOfSourceAtI = source.charAt(i)-'a';
            int charOfTargetAtI = target.charAt(i)-'a';
            // As we can only swap characters at even or odd indices
            // We will greedily check if any of them can be swapped.
            if(i%2==0){
                checkEvenIndices[charOfSourceAtI]++;
                checkEvenIndices[charOfTargetAtI]--;
            }else{
                checkOddIndices[charOfSourceAtI]++;
                checkOddIndices[charOfTargetAtI]--;
            }
        }
        for(int i=0;i<26;i++){
            if(checkEvenIndices[i]!=0 || checkOddIndices[i]!=0) return false;
        }
        return true;
    }
}