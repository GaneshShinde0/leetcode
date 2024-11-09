class Solution {
    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        StringBuilder vowelsInString = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(vowels.indexOf(s.charAt(i))>=0){
                vowelsInString.append(s.charAt(i));
            }
        }
        char[] vowelsChars = vowelsInString.toString().toCharArray();
        Arrays.sort(vowelsChars);
        int j=0;
        char[] string = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(vowels.indexOf(s.charAt(i))>=0){
                string[i]=vowelsChars[j];
                j++;
            }
        }
        return new String(string);
    }
}
