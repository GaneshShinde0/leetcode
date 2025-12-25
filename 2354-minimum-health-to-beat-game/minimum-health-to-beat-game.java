class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long res = 0, usedArmor=0;
        for(int d:damage){
            res+=d;
            if(d<=armor){
                usedArmor = Math.max(d,usedArmor);
            }else{
                usedArmor = armor;
            }
        }
        // if(usedArmor==0)usedArmor = Math.max(usedArmor,armor);
        return Math.max(res-usedArmor+1,1);
    }
}