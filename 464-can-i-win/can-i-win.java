class Solution {
    Map<Integer, Boolean> hm;
    int maxChoosableInteger;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal<=0) return true;
        int sum = (maxChoosableInteger+1)*maxChoosableInteger/2;
        if(sum<desiredTotal) return false;
        this.hm = new HashMap<>();
        this.maxChoosableInteger = maxChoosableInteger;
        return canWin(0, desiredTotal);
    }
    private boolean canWin(int used, int total){
        if(hm.containsKey(used)) return hm.get(used);
        for(int i=1; i<=maxChoosableInteger; i++){
            int mask = 1<<i;
            if((used & mask) == 0){
                if(i>=total || !canWin(used|mask, total-i)){
                    hm.put(used,true);
                    return true;
                }
            }
        }
        hm.put(used, false);
        return false;
    }
}