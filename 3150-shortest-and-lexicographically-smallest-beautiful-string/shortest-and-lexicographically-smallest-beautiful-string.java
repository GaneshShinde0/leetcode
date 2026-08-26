class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length(), onesCount = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        while(onesCount<k&&right<n){
            char c = s.charAt(right);
            sb.append(c);
            if(c=='1') onesCount++;
            right++;
        }
        String res = sb.toString();
        for(int i=1;i<=n-k;i++){
            if(sb.charAt(0)=='1') onesCount--;
            sb.deleteCharAt(0);
            while(onesCount<k && right<n){
                char c = s.charAt(right);
                sb.append(c);
                if(c=='1') onesCount++;
                right++;
            }
            if(onesCount==k && compare(sb.toString(),res) <0) res = sb.toString();
        }
        onesCount = 0;
        for(char c:res.toCharArray()) if(c=='1') onesCount++;
        return onesCount==k?res:"";
    }

    private int compare(String s1, String s2){
        if(s1.length()!=s2.length()) return Integer.compare(s1.length(), s2.length());
        else return s1.compareTo(s2);
    }
}