class Solution {
    public int shipWithinDaysInitial(int[] weights, int days) {
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

    
    public int shipWithinDays(int[] weights, int days) {
        int minPerDay  = 0;
        int n = weights.length;
        int totalWeight = 0;
        for(int i:weights){
            minPerDay = Math.max(minPerDay, i);
            totalWeight+=i;
        }
        int low = minPerDay;
        int high = totalWeight;
        int result = totalWeight; // Keep track of the best valid answer

        while(low <= high){ // Use <= to fully explore the range
            int mid = low + (high - low) / 2;
            int daysNeeded = calculateDaysWithCapacity(weights, mid);

            if(daysNeeded <= days){
                // mid works. Store it, try for a smaller one.
                result = mid;
                high = mid - 1; // Search the left half
            } else {
                // mid is too small. Increase capacity.
                low = mid + 1; // Search the right half
            }
        }
        return result;
    }
    private int calculateDaysWithCapacity(int[] weights, int capacity){
        // Start with 1 day, as we must ship all packages
        int currDays = 1; 
        int currentLoad = 0;
        
        for(int weight : weights) {
            if(currentLoad + weight <= capacity) {
                // Package fits on the current day
                currentLoad += weight;
            } else {
                // Package doesn't fit, start a new day
                currDays++;
                // The package is the first load of the new day
                currentLoad = weight;
            }
        }
        return currDays;
    }

    private int calculateDaysWithCapacityFails(int[] weights, int mid){
        int currDays = 0;
        int n = weights.length;
        int i=0;
        while(i<n){
            int temp = mid;
            currDays++;
            while(i<n && temp>=weights[i]){
                temp-=weights[i];
                i++;        
            }
        }
        return currDays;
    }
}