class Solution {
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        for(char c: chars){
            if(vowels.indexOf(c)!=-1){
                sb.append(c);
            }
        }
        char[] vowelsInS = sb.toString().toCharArray();
        Arrays.sort(vowelsInS);
        int currVowelIdx=0;
        for(int i=0;i<chars.length;i++){
            if(vowels.indexOf(chars[i])!=-1){
                chars[i]=vowelsInS[currVowelIdx];
                currVowelIdx++;
            }
        }
        return String.valueOf(chars);
    }
}