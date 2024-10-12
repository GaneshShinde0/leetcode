class Solution {
    public int minGroupsNaiveSolutionTLE(int[][] intervals) {
        // List<List<Integer>> li = new ArrayList<>();
        // Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int[] freq = new int[1000000];
        for(int[] interval: intervals){
            for(int i=interval[0];i<=interval[1];i++){
                freq[i]++;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i:freq){
            if(i>max) max = i;
        }
        return max;
    }

    // As constraint are 10^6 this will lead to TLE.
    // This problem is same as the problem where we see how many parallel requests are getting executed where left is start and right is end.
    public int minGroupsUsingPQ(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int[] interval: intervals){
            if(!minHeap.isEmpty() && interval[0]>minHeap.peek()){
                minHeap.poll();
            }
            minHeap.add(interval[1]);
        }
        return minHeap.size();
    }

    // Following solutions utilize list
    public int minGroupsUsingSorting(int[][] intervals){
        // Convert the intervals into two events
        // Start as {start, 1} and end as {end+1,-1}
        // Input : [[5,10],[6,8],[1,5],[2,3],[1,10]]

        // Note the same can be done with Arrays.sort(intervals,(a,b)->a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]))

        List<int[]> events = new ArrayList<>();
        for(int[] interval: intervals){
            events.add(new int[]{interval[0],1});
            events.add(new int[]{interval[1]+1,-1});
        }
        // System.out.println(formatEvents(events));
        // The Intervals with same key are sorted accordint to the values in ascending order. This ensures we don't overcount the intervals at that point.
        Collections.sort(events, (a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]); // Sort by type (1 before -1)
            }else{
                return Integer.compare(a[0],b[0]); // Sort by time.
            }
        });
        // System.out.println(formatEvents(events));
        int concurrentIntervals = 0;
        int maxConcurrentIntervals = 0;

        // Sweep through the events
        for(int[] event : events){
            // System.out.println("Concurrent Intervals: "+ concurrentIntervals);
            // System.out.println("Maximum Concurrent Intervals: "+ maxConcurrentIntervals);
            concurrentIntervals += event[1]; // Track currently active intervals
            maxConcurrentIntervals = Math.max(
                maxConcurrentIntervals,
                concurrentIntervals
            ); // Update Max
        }

        return maxConcurrentIntervals;
    }

    // Utility method to format the events list
    public static String formatEvents(List<int[]> events) {
        return events.stream()
                .map(arr -> Arrays.stream(arr)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]")))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public int minGroupsLineSweepAlgoWithOrderedContainer(int[][] intervals){
        // Use a TreeMap to store the points and their counts
        TreeMap<Integer, Integer> pointToCount = new TreeMap<>();

        // Mark the starting and ending points in the TreeMap
        for(int[] interval:intervals){
            pointToCount.put(
                interval[0],
                pointToCount.getOrDefault(interval[0],0)+1
            );
            pointToCount.put(
                interval[1]+1,
                pointToCount.getOrDefault(interval[1]+1,0)-1
            );
        }

        int concurrentIntervals =0;
        int maxConcurrentIntervals = 0;

        // Iterate over entries of the TreeMap in ascending order of keys.
        for(Map.Entry<Integer,Integer> entry: pointToCount.entrySet()){
            concurrentIntervals += entry.getValue();
            maxConcurrentIntervals = Math.max(
                maxConcurrentIntervals,
                concurrentIntervals
            ); // Update Max Intervals
        }
        return maxConcurrentIntervals;
    }

    // Line Sweep Algorithm Without Ordered Container
    public int minGroups(int[][] intervals){
        // Use counting sort instead of using ordered map
        int rangeStart = Integer.MAX_VALUE;
        int rangeEnd = Integer.MIN_VALUE;

        for(int[] interval: intervals){
            rangeStart = Math.min(interval[0],rangeStart);
            rangeEnd = Math.max(interval[1],rangeEnd);
        }

        // Intitialize the array with all zeroes
        int[] pointToCount = new int[rangeEnd + 2];
        for(int[] interval:intervals){
            pointToCount[interval[0]]++;
            pointToCount[interval[1]+1]--; //Decrement right after the end of the interval.
        }

        int concurrentIntervals = 0;
        int maxConcurrentIntervals = 0;
        for(int i= rangeStart;i<=rangeEnd;i++){
            // Update currently active intervals
            concurrentIntervals += pointToCount[i];
            maxConcurrentIntervals = Math.max(
                maxConcurrentIntervals,
                concurrentIntervals
            );
        }
        return maxConcurrentIntervals;
    }


}
