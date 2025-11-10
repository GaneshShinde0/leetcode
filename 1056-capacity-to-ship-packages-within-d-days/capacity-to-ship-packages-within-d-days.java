class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minPerDay  = 0;
        int n = weights.length;
        int minWeight= Integer.MAX_VALUE;
        for(int i:weights){
            minPerDay = Math.max(minPerDay, i);
            minWeight = Math.min(minWeight,i);
        }
        if(minWeight==minPerDay && days<minPerDay) return (int)(Math.ceil(n*1.0/days)*minPerDay);
        while(minPerDay<(n*minPerDay)){
            int temp = minPerDay;
            int currDays = 0;
            int i=0;
            while(i<n){
                while(i<n && temp>=weights[i]){
                    temp-=weights[i];
                    i++;        
                }
                temp = minPerDay;
                currDays++;
                if(currDays>days ) break;
            }
            if(currDays<=days && i==n) return minPerDay;
            minPerDay++;
        }
        return minPerDay;
    }
}