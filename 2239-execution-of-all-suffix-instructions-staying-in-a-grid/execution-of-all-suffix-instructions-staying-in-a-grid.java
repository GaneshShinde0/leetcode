class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()];
        for(int idx=0;idx<s.length();idx++){
            int i = startPos[0];
            int j = startPos[1];
            int curr = 0;
            for(int k=idx;k<s.length();k++){
                if(s.charAt(k)=='U'){
                    i-=1;
                }else if(s.charAt(k)=='D'){
                    i+=1;
                }else if(s.charAt(k)=='L'){
                    j-=1;
                }else if(s.charAt(k)=='R'){
                    j+=1;
                }
                if(i<0||j<0||i>=n||j>=n) break;
                else curr++;
            }
            res[idx]=curr;
        }
        return res;
    }
}