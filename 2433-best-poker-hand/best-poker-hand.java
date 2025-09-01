class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int suitsCount = 1;
        for(int i=1;i<suits.length;i++){
            if(suits[i]==suits[i-1]) suitsCount++;
        }
        if(suitsCount == 5) return "Flush";
        int ranksCount = 1, maxRanksCount = 1;
        Arrays.sort(ranks);
        for(int i=1;i<5;i++){
            if(ranks[i]==ranks[i-1]){
                ranksCount++;
                maxRanksCount = Math.max(ranksCount,maxRanksCount);
            }
            else ranksCount = 1;
        }
        if (maxRanksCount>=3) return "Three of a Kind";
        else if(maxRanksCount == 2) return "Pair";
        else return "High Card";
    }
}