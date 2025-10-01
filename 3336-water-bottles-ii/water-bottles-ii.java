class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = numBottles, bottlesDrunk=numBottles;
        numBottles=0;
        while(emptyBottles>=numExchange||numBottles>0){
            if(emptyBottles>=numExchange){
                emptyBottles-=numExchange;
                numExchange++;
                numBottles++;
            }else{
                bottlesDrunk+=numBottles;
                emptyBottles+=numBottles;
                numBottles=0;
            }
        }
        return bottlesDrunk;
    }
}