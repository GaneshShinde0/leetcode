class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        List<List<Integer>> result = new ArrayList<>();
        for(int[] interval:intervals){
            if((interval[0]<toBeRemoved[0] && interval[1]>toBeRemoved[1])){
                result.add(List.of(interval[0],toBeRemoved[0]));
                result.add(List.of(toBeRemoved[1],interval[1]));
            }else if(interval[0]>=toBeRemoved[0] && interval[1]<=toBeRemoved[1]) continue;
            else if(interval[1]<=toBeRemoved[0]|| interval[0]>=toBeRemoved[1]) result.add(toList(interval));
            else if(interval[0]<toBeRemoved[0] && interval[1]>=toBeRemoved[0]) result.add(List.of(interval[0],toBeRemoved[0]));
            else if(interval[0]>=toBeRemoved[0] && interval[1]>toBeRemoved[1]) result.add(List.of(toBeRemoved[1],interval[1]));
        }
        return result;
    }

    private List<Integer> toList(int[] interval){
        List<Integer> result = IntStream.of(interval).boxed().collect(Collectors.toList());
        return result;
    }
}