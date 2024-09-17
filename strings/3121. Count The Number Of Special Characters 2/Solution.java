class Solution {
    public int numberOfSpecialChars(String s) {
        int count=0;
        for(int i=25;i>=0;i--){
            int idx = s.lastIndexOf('a'+i);
            if(idx!=-1 && idx<s.indexOf('A'+i)){
                count++;
            }
        }
        return count;
    }

     public int numberOfSpecialCharsOptimized(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        for(int i=0;i<26;i++){
            lower[i]=-1;
            upper[i]=Integer.MAX_VALUE;
        }

        for(int i=0;i<word.length();i++){
            char j = word.charAt(i);
            if(j-'a'>=0){
                lower[j-'a'] = i;
            }
            else{
                upper[j-'A'] = Math.min(i,upper[j-'A']);
            }
        }
        
        int result=0;
        for(int i=0;i<26;i++){
            if(upper[i]==Integer.MAX_VALUE || lower[i]==-1)
                continue;
            if(upper[i]>lower[i])
                result+=1;
        }
        return result;
    }
}
