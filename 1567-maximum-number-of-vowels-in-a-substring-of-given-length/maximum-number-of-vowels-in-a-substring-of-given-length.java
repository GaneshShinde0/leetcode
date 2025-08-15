class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        String vowels = "aeiou";
        int[] freq = new int[26];
        int res = 0,vowelCount=0;
        for(int i=0;i<Math.min(k,n);i++){
            char c = s.charAt(i);
            if(vowels.indexOf(c)!=-1) vowelCount++;
        }

        for(int i=k;i<n;i++){
            res = Math.max(res,vowelCount);
            if(vowels.indexOf(s.charAt(i-k))!=-1){
                vowelCount--;
            }
            char c = s.charAt(i);
            if(vowels.indexOf(c)!=-1){
                vowelCount++;
            }
        }
        res = Math.max(res,vowelCount);
        return res;
    }
}