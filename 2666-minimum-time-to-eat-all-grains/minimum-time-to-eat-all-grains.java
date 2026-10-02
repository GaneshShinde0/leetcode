class Solution {
    public int minimumTime(int[] hens, int[] grains) {
        //Sort both the arrays.
        Arrays.sort(hens);
        Arrays.sort(grains);
        //Binary search the answer.
        int start = 0, end = 1_500_000_000;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(check(hens, grains, mid))
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }
    public boolean check(int[] hens, int[] grains, int time) {
        int n = hens.length, m = grains.length, h = 0, g = 0;
        // h is pointer for current leftmost hen in hens array.
        // g is pointer for the current leftmost un-eaten grain in grains array.
        while(h < n && g < m) {
            // Current hen at index h will travel from [henLeft, henRight].
            int henLeft, henRight;

            // If there is a grain to the of current hen,
            // it will have to eat this grain.
            if(grains[g] < hens[h]) {

                // Time left after going to left for this grain
                int timeLeft = time - (hens[h] - grains[g]);
                // If the grain is too far, timeLeft will be negative,
                // it is not possible to eat this grain in given time.
                if(timeLeft < 0) return false;

                henLeft = grains[g];

                // Hen can first go left, or go right and come back to left.
                henRight = Math.max(henLeft + timeLeft, hens[h] + timeLeft / 2);
            } 
            // If there is no grain to left, just go right.
            else {
                henLeft = hens[h];
                henRight = hens[h] + time;
            }
            // Consume all grains in the range [henLeft, henRight].
            while(g < m && grains[g] >= henLeft && grains[g] <= henRight) {
                g++;
            }
            h++;
        }
        // Return true if all grains have been consumed.
        return g == m;
    }
}