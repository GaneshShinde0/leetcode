/*
- prefSum is the prefix sum from skills[0] to skill[i];
- t is startTime
- finish = startTime + mana[j-1]*prefSum[i+1] is the finish time of ith wizard in the last round.
- start_i = finish - mana[j]*acc[i] is the earlist start time of for the next round.
- For each round we calculate the maX(start_i);
- If we start earlier, There will atleast one wizard can't finish in the previous round.
- Finally we find the start time for the latest round.

*/
class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] prefSum = new long[n+1];
        for(int i=0;i<n;i++){
            prefSum[i+1]=prefSum[i]+skill[i];
        }
        long startTime = 0, endTime = 0;
        for(int j=1;j<m;j++){
            endTime = 0;
            for(int i=0;i<n;i++){
                endTime = Math.max(endTime,startTime+mana[j-1]*prefSum[i+1]-mana[j]*prefSum[i]);
            }
            startTime = endTime;
        }
        return startTime + mana[m-1]*prefSum[n];
    }
}