import java.util.*;

class Solution {
    public int maximumTeamSize(int[] start, int[] end) {

        int n = start.length;

        int[] sortedStart = start.clone();
        int[] sortedEnd = end.clone();

        Arrays.sort(sortedStart);
        Arrays.sort(sortedEnd);

        int maxTeamSize = 0;

        for (int i = 0; i < n; i++) {
            // Number of intervals whose start <= current end
            int intervalsStarted = upperBound(sortedStart, end[i]);
            // Number of intervals whose end < current start
            int intervalsFinished = lowerBound(sortedEnd, start[i]);
            // Intervals that overlap with [start[i], end[i]]
            int teamSize = intervalsStarted - intervalsFinished;
            maxTeamSize = Math.max(maxTeamSize, teamSize);
        }

        return maxTeamSize;
    }

    // Returns the first index where arr[index] > target.
    // Therefore, it also equals the number of elements <= target.
    private int upperBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Returns the first index where arr[index] >= target.
    // Therefore, it also equals the number of elements < target.
    private int lowerBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}