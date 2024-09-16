class Solution {

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] parsedMinutes = new int[n];

        // Parse each time point and store in the parsedMinutes array
        for (int i = 0; i < n; i++) {
            parsedMinutes[i] = parseMinutes(timePoints.get(i));
        }

        // Sort the parsed minutes array
        Arrays.sort(parsedMinutes);

        // Initial minimum difference between the first and last time point (circular case)
        int minDiff = getTimeDifference(parsedMinutes[0], parsedMinutes[n - 1]);

        // Compare consecutive parsed minutes to find the minimum difference
        for (int i = 1; i < n; i++) {
            int diff = parsedMinutes[i] - parsedMinutes[i - 1];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    // Get time difference considering circular wrap
    private int getTimeDifference(int minutes1, int minutes2) {
        int diff = Math.abs(minutes1 - minutes2);
        // Handle circular difference (as time wraps around after 24 hours)
        return Math.min(diff, 1440 - diff);
    }
    
    public int findMinDifferenceNaive(List<String> timePoints) {
        Collections.sort(timePoints);
        int min =Math.abs(parseMinutes(timePoints.get(0))-parseMinutes(timePoints.get(timePoints.size()-1)));
        min = Math.min(min, 1440-min);
        System.out.println(timePoints);
        for(int i=1;i<timePoints.size();i++){
            int temp = (Math.abs(parseMinutes(timePoints.get(i))-parseMinutes(timePoints.get(i-1))));
            if(Math.min(temp,1440-temp)<min){
                min = Math.min(temp,1440-temp);
            }
        }
        return min;
    }
    public int parseMinutes(String s){
        int i=Integer.parseInt(s.substring(0,2))*60;
        i+=Integer.parseInt(s.substring(3,5));
        return i;
    }
}
