class Solution {
    public int maxFreqSum(String s) {
        String vowels = "aeiou";
        int[] freq = new int[26];
        int maxVowels=0, maxCons=0;
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        for(int i=0;i<26;i++){
            char temp =(char) (i+'a');
            // System.out.println(temp);
            if(vowels.indexOf(temp)!=-1){
                maxVowels = Math.max(maxVowels, freq[i]);
            }else{
                maxCons = Math.max(maxCons, freq[i]);
            }
        }
        return maxVowels+maxCons;
    }
}