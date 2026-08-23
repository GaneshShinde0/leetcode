class Solution {
    public boolean sumGame(String num) {
        int n = num.length(), leftQ=0, rightQ=0, mid = n/2,leftSum=0, rightSum=0;
        for(int i=0;i<n;i++){
            if(i<mid){
                if(num.charAt(i)=='?') leftQ++;
                else leftSum += num.charAt(i)-'0';
            }else{
                if(num.charAt(i)=='?') rightQ++;
                else rightSum += num.charAt(i)-'0';
            }
        }
        
        // If the total number of '?' is odd, Alice makes the last move and guarantees a win.
        if((leftQ+rightQ)%2!=0) return true;

        // If the total ? is even, Bob wins only if the difference in sums can be 
        // Perfectly baancced by the difference in '?'.
        // Every 2 extra '?' on one side can beforced by bob to add exactly 9.
        return (leftSum-rightSum)*2 != (rightQ-leftQ)*9;
    }
}

/*
99?11?

ALice will try to increase the gap, bob will try to reduce the gap.
11??111?

if(leftSum-rightSum>10) Alice will always win...

1329

599?
*/