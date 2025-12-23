class Solution {
    public int maxTwoEvents1(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int[][] dp = new int[events.length][3]; // Three Choices
        for(int[] d:dp) Arrays.fill(d,-1);
                // System.out.println(Arrays.toString(dp[events.length-1]));
                // System.out.println(Arrays.toString(dp[0]));
                // return 0;
        return findEvents(events,0,0,dp);
    }

    private int findEvents(int[][] events, int idx, int count, int[][] dp){
        int n = events.length;
        if(count==2||idx>=n) return 0;
        if(dp[idx][count]==-1){
            int end = events[idx][1];
            int low = idx+1, high = n-1;
            while(low<high){
                int mid = low + (high-low)/2;
                if(events[mid][0]>end) high = mid; // Checking event which started after previous event ended.
                else low = mid+1;
            }
            int include = events[idx][2]; // Including Current Event
            if(low<n && events[low][0]>end){
                include += findEvents(events, low, count+1, dp);
            }
            int exclude = findEvents(events,idx+1, count, dp); // Excluding the curerent Event;
            dp[idx][count] = Math.max(include, exclude); 
        }
        return dp[idx][count];
    }

    public int maxTwoEvents(int[][] events) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(Pair::getKey)
        );

        Arrays.sort(events, (a,b)-> a[0]-b[0]);
        int maxVal = 0, maxSum = 0;
        
        for(int[] event: events){
            while(!pq.isEmpty() && pq.peek().getKey()<event[0]){
                maxVal = Math.max(maxVal, pq.peek().getValue());
                pq.poll();
            }
            maxSum = Math.max(maxSum, maxVal+event[2]);
            pq.add(new Pair<>(event[1],event[2]));
        }
        return maxSum;
    }
}