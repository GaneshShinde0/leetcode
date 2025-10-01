class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = numBottles, bottlesDrank = numBottles;
        numBottles = 0;
        while(numBottles>0||emptyBottles>=numExchange){
            if(emptyBottles>=numExchange){
                emptyBottles-=numExchange;
                numExchange++;
                numBottles++;
            }else{
                bottlesDrank+=numBottles;
                emptyBottles+=numBottles;
                numBottles=0;
            }
        }
        return bottlesDrank;
    }
}