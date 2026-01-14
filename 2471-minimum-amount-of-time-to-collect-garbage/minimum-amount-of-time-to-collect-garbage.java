/*
Input: garbage = ["G","P","GP","GG"], travel = [2,4,3]

Paper: (2)=>2+1=> 3+(4)+1=> 8
Metal: 0 
Glass: 1 => 1+(2) =>3+(4)+1 => 8+(3)+2=>13 
*/
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int p=0, g=0, m=0;
        int res = 0;
        int pu=0 , gu=0, mu = 0; // Paper, Glass, Metal Units.
        for(int i=0; i<garbage.length; i++){
            for(char c:garbage[i].toCharArray()){
                if(c=='G') {
                    gu++;
                    g=i;
                }
                if(c=='P'){
                    pu++;
                    p=i;
                }
                if(c=='M'){
                    mu++;
                    m=i;
                }
            }
        }
        res+=calculateTravelTime(travel,g)+gu;
        res+=calculateTravelTime(travel,m)+mu;
        res+=calculateTravelTime(travel,p)+pu;
        return res;
    }
    private int calculateTravelTime(int[] travel, int lastHouse){
        int travelTime = 0;
        for(int i=0;i<lastHouse;i++){
            travelTime +=travel[i];
        }
        return travelTime;
    }
}