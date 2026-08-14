class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        
        for(int i=0;i<s.length();i++){
            char[] data = new char[26];
            int count = 0;
            // boolean check = true;
            for(int j=i;j<s.length();j++){
                // System.out.println(i+" "+j);
                data[s.charAt(j)-'a']++;
                if(data[s.charAt(j)-'a'] > 2)  break;
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}