class Solution {
    public int maxScoreBruteForce(String s) {
        int ans = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            int curr = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') {
                    curr++;
                }
            }
            
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    curr++;
                }
            }
            
            ans = Math.max(ans, curr);
        }
        
        return ans;
    }

    public int maxScoreCountLeftZeroesAndRightOnes(String s){
        int ones = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                ones++;
            }
        }
        int ans = 0;
        int zeros = 0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='1'){
                ones--;
            }else{
                zeros++;
            }
            ans = Math.max(ans,zeros+ones);
        }
        return ans;
    }

    public int maxScore(String s){
        int ones = 0;
        int zeros = 0;
        int best = Integer.MIN_VALUE;

        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='1'){
                ones++;
            }else{
                zeros++;
            }
            best = Math.max(best,zeros-ones);
        }

        if(s.charAt(s.length()-1)=='1'){
            ones++;
        }
        return best+ones;
    }
}
