class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitTime = 0;
        double currEndTime = 0;
        for(int i=0;i<customers.length;i++){
            if(customers[i][0]>currEndTime){
                totalWaitTime+=customers[i][1];
                currEndTime=customers[i][0]+customers[i][1];
            }else{
                totalWaitTime+=currEndTime-customers[i][0]+customers[i][1];
                currEndTime = currEndTime+customers[i][1];
            }
        }
        return totalWaitTime/customers.length;
    }
}