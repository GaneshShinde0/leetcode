class Solution {
    public int[] maxUpgrades(int[] count, int[] upgrade, int[] sell, int[] money) {
        int n = count.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = getBestScenario(count[i],upgrade[i], sell[i], money[i]);
        }
        return res;
    }

    private int getBestScenario(long count, long upgrade, long sell,long money){
        long left = 0, right = count;
        while(left<=right){
            long mid = (left+right)/2;
            long newMoney = money + (count-mid)*sell;
            if(newMoney/upgrade>=mid){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return (int) right;
    }
}