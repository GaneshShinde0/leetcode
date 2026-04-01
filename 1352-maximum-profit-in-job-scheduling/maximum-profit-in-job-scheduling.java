class Solution {
    public int jobSchedulingInitial(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] startEndProfit = new int[n][3];
        for (int i = 0; i < n; i++) {
            startEndProfit[i][0] = startTime[i];
            startEndProfit[i][1] = endTime[i];
            startEndProfit[i][2] = profit[i];
        }
        Arrays.sort(startEndProfit, (a, b) -> Integer.compare(a[1], b[1]));
        int[] profitAt = new int[n];
        profitAt[0] = startEndProfit[0][2];
        int result = startEndProfit[0][2];
        for (int i = 1; i < n; i++) {
            profitAt[i] = Math.max(startEndProfit[i][2], profitAt[i - 1]);
            for (int j = i - 1; j >= 0; j--) {
                if (startEndProfit[i][0] >= startEndProfit[j][1]) {
                    profitAt[i] = Math.max(profitAt[i], startEndProfit[i][2] + profitAt[j]);
                    break;
                }
            }
            result = Math.max(profitAt[i], result);
        }
        return result;
    }

    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] startEndProfit = new int[n][3];
        for (int i = 0; i < n; i++) {
            startEndProfit[i][0] = startTime[i];
            startEndProfit[i][1] = endTime[i];
            startEndProfit[i][2] = profit[i];
        }
        Arrays.sort(startEndProfit, (a, b) -> Integer.compare(a[1], b[1]));
        int[] profitAt = new int[n];
        profitAt[0] = startEndProfit[0][2];
        int result = startEndProfit[0][2];
        for (int i = 1; i < n; i++) {
            profitAt[i] = Math.max(startEndProfit[i][2], profitAt[i - 1]);
            int j = binarySearch(startEndProfit, i-1, startEndProfit[i][0]);
            if(j!=-1) profitAt[i] = Math.max(profitAt[i], startEndProfit[i][2] + profitAt[j]);
            result = Math.max(profitAt[i], result);
        }
        return result;
    }

    private int binarySearch(int[][] arr, int end, int targetStartTime){
        int start = 0, result = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid][1]<=targetStartTime){
                result = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return result;
    }
}