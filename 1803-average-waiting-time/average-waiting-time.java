class Solution {
    public double averageWaitingTimeInitial(int[][] customers) {
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

    public double averageWaitingTime(int[][] customers) {
        double totalWaitTime=0, currentEndTime=0;
        for(int[] customer:customers){
            currentEndTime = Math.max(currentEndTime,customer[0])+customer[1];
            totalWaitTime += currentEndTime-customer[0];
        }
        return totalWaitTime/customers.length;
    }
}