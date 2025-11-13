class Solution {
    public int maxOperations(String s) {
        int res = 0;
        int onesCount = 0, zerosCount = 0;
        int n = s.length();
        int i =0 ;
        while(i<n){
            while(i<n && s.charAt(i)=='1'){
                onesCount++;
                i++;
            }
            while(i<n && s.charAt(i)=='0'){
                i++;
                zerosCount++;
            }
            if(zerosCount>0) res+=onesCount;
            zerosCount = 0;
        }
        return res;
        
    }
}