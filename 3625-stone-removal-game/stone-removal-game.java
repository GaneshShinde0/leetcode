class Solution {
    public boolean canAliceWin(int n) {
        int i = 10;
        boolean winner = false;
        while(n>=i){
            n-=i;
            i--;
            winner = !winner;
            if(n<i){
                return winner;
            }
        }
        return winner;
    }
}