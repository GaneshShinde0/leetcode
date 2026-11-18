class Solution {
    public int minChangesInitial(String s) {
        int n = s.length();
        int count=0;
        int oneCount=0;
        int zeroCount=0;
        for(int i=0;i<n;i+=2){
            if(s.charAt(i+1)==s.charAt(i))continue;
            zeroCount++;
            oneCount++;
        }
        return Math.min(zeroCount,oneCount);
    }
    public int minChangesOptimized(String s) {
        int n = s.length();
        int zeroCount=0;
        for(int i=0;i<n;i+=2){
            if(s.charAt(i+1)==s.charAt(i));
            else zeroCount++;
        }
        return zeroCount;
    }
    public int minChanges(String s) {
        int ans=0,c=0;
        for(int i=0;i<s.length();i++){
            c+=s.charAt(i)-'0';
            if(i%2==1){
                ans+=(c%2);
                c=0;
            }
        }
        return ans;
    }
}