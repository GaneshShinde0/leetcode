class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        int maxPens = total/cost1, maxPencils = total/cost2;
        for(int i=0;i<=maxPens;i++){
            int pencilsBought = (total-cost1*i)/cost2+1; // we have to consider posibility of 0 as well so +1
            res+=pencilsBought; 
        }
        return res;
    }
}