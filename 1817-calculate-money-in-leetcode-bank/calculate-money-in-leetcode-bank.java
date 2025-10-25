class Solution {
    public int totalMoney(int n) {
        int weeks = n/7;
        int remainder = n%7;
        int inAWeek = 28; //7*(8)/2 
        int total = 0;
        if(weeks>0) total = inAWeek*weeks+7*(weeks*(weeks-1)/2);
        for(int i=1;i<=remainder;i++){
            total +=weeks+i;
        }
        return total;
    }
}