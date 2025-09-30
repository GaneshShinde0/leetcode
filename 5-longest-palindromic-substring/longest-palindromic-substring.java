class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int res = 1;
        String resString = "";
        for(int i=0;i<n;i++){
            int left = i-1, right = i+1;
            while(left>=0&&right<n){
                if(s.charAt(left)==s.charAt(right)){
                    res = Math.max(res,right-left+1);
                    if(resString.length()<res) resString = s.substring(left,right+1);
                    left--;right++;
                }else{
                    break;
                }
            }
            left = i;right=i+1;
            while(left>=0&&right<n){
                if(s.charAt(left)==s.charAt(right)){
                    res = Math.max(res,right-left+1);
                    if(resString.length()<res) resString = s.substring(left,right+1);
                    left--;right++;
                }else{
                    break;
                }
            }
        }
        if(resString.length()==0&&n>=1)return s.substring(0,1);
        return resString;
    }
}