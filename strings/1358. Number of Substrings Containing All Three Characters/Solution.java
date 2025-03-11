class Solution {
    public int numberOfSubstringsTLE(String s) {

        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int res = 0;

        char[] arr = {'a','b','c'};

        for(int i=0;i<n-1;i++){
            for(int j=i+3;j<=n;j++){
                String temp= s.substring(i,j);
                boolean isSubstring=true;
                for(char c:arr){
                    if(temp.indexOf(c)==-1){
                        isSubstring=false;
                        break;
                    }
                }
                if(isSubstring) res++;
            }
        }
        return res;
    }

    public int numberOfSubstringsLastPositionTracking(String s){
        int n = s.length();
        int[] lastPos = {-1,-1,-1};
        int total = 0;
        for(int i=0;i<n;i++){
            lastPos[s.charAt(i)-'a']=i;

            // Add count of valid substrings ending at current position
            // If any character is missing, min will be -1
            // Else min gives leftmost required character position.
            total += (1+Math.min(lastPos[0], Math.min(lastPos[1], lastPos[2])));
        }
        return total;
    }

    public int numberOfSubstrings(String s){
        int n = s.length();
        int left = 0, right =0;
        int[] freq = new int[3];
        int total = 0;

        while(right<n){
            char curr = s.charAt(right);
            freq[curr-'a']++;
            while(hasAllChars(freq)){
                total+=n-right;
                char leftChar = s.charAt(left);
                freq[leftChar-'a']--;
                left++;
            }
            right++;
        }
        return total;
    }

    private boolean hasAllChars(int[] freq){
        return freq[0]>0 && freq[1]>0 && freq[2]>0;
    }
}
