class Solution {
    public int maxBottlesDrunkInitial(int numBottles, int numExchange) {
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
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = numBottles;
        int bottlesDrank = numBottles;

        while (emptyBottles >= numExchange) {
            emptyBottles -= numExchange; // trade for one new bottle
            numExchange++;              // exchange cost increases
            bottlesDrank++;             // drink that bottle
            emptyBottles++;             // empty bottle from drinking
        }

        return bottlesDrank;
    }
}