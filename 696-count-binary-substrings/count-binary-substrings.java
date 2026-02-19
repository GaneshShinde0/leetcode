class Solution {
    public int countBinarySubstrings(String s){
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0]=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)!=s.charAt(i)){
                groups[++t]=1;
            }else{
                groups[t]++;
            }
        }
        int ans = 0;
        for(int i=1;i<=t;i++){
            ans+=Math.min(groups[i-1],groups[i]);
        }
        return ans;
    }
    public int countBinarySubstringsDoesNotWork(String s) {
        int zeros = 0;
        int ones = 0;
        int result = 0;
        int i = 0, n = s.length();
        while(i<n){
            while(i<n && s.charAt(i)=='0'){
                zeros++;
                i++;
            }
            result += Math.min(zeros,ones);
            if(i==n) break;
            while(i<n && s.charAt(i)=='1'){
                ones++;
                i++;
            }
            result += Math.min(zeros,ones);
            if(i<n && s.charAt(i)=='0') zeros = 0;
            else ones= 0;
        }
        // zeros=0;
        // ones=0;
        // i = 0;
        // while(i<n){
            
        //     while(i<n && s.charAt(i)=='1'){
        //         ones++;
        //         i++;
        //     }
        //     while(i<n && s.charAt(i)=='0'){
        //         zeros++;
        //         i++;
        //     }
        //     result += Math.min(zeros,ones);
        //     if(i<n && s.charAt(i)=='0') ones = 0;
        //     else zeros= 0;
        // }
        // for(char c:s.toCharArray()){
        //     while(c=='0'){
        //         zeros++;
        //         if(zeros==ones) result+=zeros;
        //         ones=0;
        //     }else{
        //         ones++;
        //         if(zeros==ones){
        //             result+=ones;
        //             zeros=0;
        //         }
        //     }
        // }
        return result;
    }
}