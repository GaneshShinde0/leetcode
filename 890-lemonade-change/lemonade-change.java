class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives=0,tens=0,twenty=0;
        for(int b:bills){
            if(b==5) fives++;
            else if(b==10) tens++;
            else if (b==20) twenty++;
            int change = b-5;
            if(change==5){
                if(fives>0) fives--;
                else return false;
            }if(change==15){
                if(tens>0 && fives>0){
                    tens--;
                    fives--;
                }else if(fives>2){
                    fives-=3;
                }
                else return false;
            }
        }
        return true;
    }
}