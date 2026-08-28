/*
- Check if palindrome can be formed?
- Check strictly greater permutation
*/
class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        if(s.length()==1 && s.compareTo(target)>0) return s;
        else if(s.length()==1) return "";
        int[] freq = new int[26], halfFreq = new int[26];
        for(char c:s.toCharArray()) freq[c-'a']++;
        for(int i=0;i<26;i++) halfFreq[i] = freq[i]/2;
        if(!isPalindrome(freq)) return "";
        return formPalindrome(freq,halfFreq, target, new StringBuilder(),0, false);
    }
    private String formPalindrome(int[] freq, int[] halfFreq, String target, StringBuilder sb, int targetPtr, boolean foundGreater){
        if(targetPtr == target.length()/2){
            String rev = sb.reverse().toString();
            sb.reverse();
            if(target.length()%2==1) return sb.toString()+getOddFreqChar(freq)+rev;
            else return sb.toString()+rev;
        }
        if (foundGreater) {
            for (int j = 0; j < 26; j++) {
                if (halfFreq[j] > 0) {
                    sb.append(((char)(j + 'a') + "").repeat(halfFreq[j]));
                }
            }

            String rev = new StringBuilder(sb).reverse().toString();

            if (target.length() % 2 == 1)
                return sb + "" + getOddFreqChar(freq) + rev;
            else
                return sb + "" + rev;
        }
        char currTarget = target.charAt(targetPtr);
        for(int i=0;i<halfFreq.length;i++){
            if(halfFreq[i]==0) continue;
            String temp1 = "", temp2 = "";
            if(!foundGreater && i==(currTarget-'a')){
                sb.append(((char)(i+'a')+""));
                halfFreq[currTarget-'a']--;
                temp1 = formPalindrome(freq,halfFreq, target,sb,targetPtr+1,foundGreater);
                if(temp1.compareTo(target)>0) return temp1;
                sb.deleteCharAt(sb.length()-1);
                halfFreq[currTarget-'a']++;
            }
            if(!foundGreater && i>(currTarget-'a')){
                sb.append(((char)(i+'a')+""));
                halfFreq[i]--;
                return formPalindrome(freq,halfFreq, target,sb,targetPtr+1,true);
            }
        }
        return "";
    }

    private char getOddFreqChar(int[] freq){
        for(int i=0;i<freq.length;i++){
            if(freq[i]%2==1) return (char) (i+'a');
        }
        return '#';
    }

    private boolean isPalindrome(int[] freq){
        int odds = 0;
        for(int i:freq) if(i%2==1) odds++;
        return odds<=1;
    }
}