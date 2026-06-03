class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int land = Integer.MAX_VALUE, water = Integer.MAX_VALUE, land_water = Integer.MAX_VALUE, water_land = Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            land = Math.min(landStartTime[i]+landDuration[i],land);
        }
        for(int i=0;i<waterStartTime.length;i++){
            water = Math.min(waterStartTime[i]+waterDuration[i],water);
            land_water = Math.min(land_water, Math.max(land,waterStartTime[i])+waterDuration[i]);
        }
        for(int i=0;i<landStartTime.length;i++){
            water_land = Math.min(water_land, Math.max(water, landStartTime[i])+landDuration[i]);
        }
        return Math.min(land_water, water_land);
    }
}