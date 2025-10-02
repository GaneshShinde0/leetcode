class Solution {
    public String minWindowInitial(String s, String t) {
        int left = 0, right = 0, n=s.length(),res=Integer.MAX_VALUE, tLength=t.length();
        int finalLeft =0,finalRight=0;
        int[] freqS = new int[128];
        int[] freqT = new int[128];
        for(char c:t.toCharArray()){
            freqT[c-'A']++;
        }

        for(;right<n;right++){
            int rightIndex = s.charAt(right)-'A';
            int leftIndex = s.charAt(left)-'A';
            freqS[s.charAt(right)-'A']++;
            while(freqS[leftIndex]>freqT[leftIndex]&&left<=right-tLength){
                freqS[leftIndex]--;
                left++;
                leftIndex = s.charAt(left)-'A';
                if(checkFreq(freqS,freqT)){
                    if(res>right-left){
                        finalLeft=left;
                        finalRight=right;
                        res=right-left;
                    }
                }
            }
            if(checkFreq(freqS,freqT)){
                if(res>right-left){
                    finalLeft=left;
                    finalRight=right;
                    res=right-left;
                }
            }
        }
        // System.out.println(Arrays.toString(freqS));
        // System.out.println(Arrays.toString(freqT));
        // System.out.println("Left: "+left+", Right: "+right);
        // System.out.println("FinalLeft: "+finalLeft+", FinalRight: "+finalRight);
        // System.out.println("Res: "+res);
        if(!checkFreq(freqS,freqT)) return "";
        return s.substring(finalLeft,finalRight+1);
    }
    private boolean checkFreq(int[] freqS, int[] freqT){
        for(int i=0;i<128;i++){
            if(freqT[i]>freqS[i]) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[128];
        for (char c : t.toCharArray()) freq[c]++;

        int required = t.length(), left = 0, minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            if (freq[s.charAt(right)]-- > 0) required--;

            while (required == 0) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    start = left;
                }
                if (++freq[s.charAt(left++)] > 0) required++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}