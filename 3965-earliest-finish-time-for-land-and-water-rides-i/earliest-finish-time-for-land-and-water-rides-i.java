class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length, m = waterStartTime.length, inf = Integer.MAX_VALUE, land = inf, water = inf, land_water = inf, water_land = inf;
        for (int i = 0; i < n; ++i) {
            land = Math.min(land, landStartTime[i] + landDuration[i]);
        }
        for (int i = 0; i < m; ++i) {
            water = Math.min(water, waterStartTime[i] + waterDuration[i]);
            land_water = Math.min(land_water, Math.max(waterStartTime[i], land) + waterDuration[i]);
        }
        for (int i = 0; i < n; ++i) {
            water_land = Math.min(water_land, Math.max(landStartTime[i], water) + landDuration[i]);
        }
        return Math.min(water_land, land_water);
    }
}