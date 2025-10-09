class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
       int calConsumed = 0,points =0, n=calories.length;
       for(int i=0;i<k;i++){
            calConsumed+=calories[i];
       }
       for(int i=k;i<n;i++){
        if(calConsumed>upper) points++;
        else if(calConsumed<lower) points--;
        calConsumed+=calories[i];
        calConsumed-=calories[i-k];
       }
       
       if(calConsumed>upper) points++;
        else if(calConsumed<lower) points--;
       return points;
    }
}