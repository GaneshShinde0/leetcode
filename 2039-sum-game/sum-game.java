class Solution {
    public boolean sumGame(String num) {
        int left = 0, right = 0, leftQ=0, rightQ=0, n=num.length(),mid = n/2;
        for(int i=0;i<n;i++){
            char c = num.charAt(i);
            if(i<mid){
                if(c=='?') leftQ++;
                else left += (c-'0');
            }else{
                if(c=='?') rightQ++;
                else right += (c-'0');
            }
        }
        // If the total number of '?' is odd, Alice makes the last move and guarantees a win.
        if((leftQ+rightQ)%2!=0) return true;

        // If the total ? is even, Bob wins only if the difference in sums can be 
        // Perfectly baancced by the difference in '?'.
        // Every 2 extra '?' on one side can beforced by bob to add exactly 9.
        return (left-right)*2 != (rightQ-leftQ)*9;

    }
}