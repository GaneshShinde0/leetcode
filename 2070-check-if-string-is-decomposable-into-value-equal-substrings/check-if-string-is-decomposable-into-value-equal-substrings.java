// I can also do this by creating a function which counts number of distinct characters in substring of groups three.
// If count is 3 return false..
// If count is 2 check if first and second is equal else return false
// If first and second are same then increment next itr by +2 instead of +3
class Solution {
    public boolean isDecomposableInitialFailsThreeTestCases(String s) {
        int count = 1;
        int ones = 0;
        int twos = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                if(count==2 && twos ==0){
                    twos++;
                } else if (count ==2 && twos!=0){
                    return false;   
                }else{
                    ones++;
                }
                count = 1;
            }
            if(count%3==0) count = 0;
        }
        if(ones>Math.ceil(s.length()/3.0)) return false;
        return  s.length()%3==2;
    }
    public boolean isDecomposable(String s) {
        int n = s.length();
        int twoGroup = 0; // count of groups with remainder 2
        int i = 0;

        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            int len = j - i;

            if (len % 3 == 1) {
                return false; // can't decompose this group
            } else if (len % 3 == 2) {
                twoGroup++;
                if (twoGroup > 1) return false;
            }

            i = j; // move to next group
        }

        return twoGroup == 1;
    }

}