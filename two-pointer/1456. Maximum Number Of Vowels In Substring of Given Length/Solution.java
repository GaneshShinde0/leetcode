class Solution {
    Set<Character> vowels = new HashSet<>();
    String vowel = "aeiou";
    public int maxVowels(String s, int k){
        int count = 0;
        for(int i=0;i<k;i++){
            if(vowel.indexOf(s.charAt(i))!=-1)count++; 
        }
        int res = count;
        for(int i=k;i<s.length();i++){
            if(vowel.indexOf(s.charAt(i))!=-1) count++;
            if(vowel.indexOf(s.charAt(i-k))!=-1)count--;
            res = Math.max(count,res);
        }
        return res;
    }
    public int maxVowelsInitialSolutionTLE(String s, int k) {
        int start =0;
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        // System.out.println(s.length());
        char[] chars = s.toCharArray();
        int maxVowels = Integer.MIN_VALUE;
        for(int i=0;i<s.length()-k+1;i++){
            maxVowels = Math.max(maxVowels, getVowelCount(chars,i,k));
            // System.out.println(s.substring(i,i+k));
        }
        return maxVowels;
    }
    private int getVowelCount(char[] arr, int i, int j){
        int count=0;
        for(int start =i;start<i+j;start++){
            if(vowel.indexOf(arr[start])!=-1){
                count++;
            }
        }
        return count;
    }
}
