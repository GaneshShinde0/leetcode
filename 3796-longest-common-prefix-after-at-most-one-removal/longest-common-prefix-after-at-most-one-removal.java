class Solution {
    public int longestCommonPrefix(String s, String t) {
        int i=0,j=0, m = s.length(),n=t.length(), res = 0, temp = 0;;
        while(i<m && j<n){
            if(s.charAt(i)!=t.charAt(j)){
                i++;
                temp++;
                if(temp>1) break;
            }else if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
                res++;
            }
        }
        return res;
    }
}