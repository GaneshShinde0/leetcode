class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int numOfRooms = 1;
        int n = intervals.length;
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        int[] currMeetings = new int[n];
        for(int[] interval:intervals){
            hm.put(interval[0],hm.getOrDefault(interval[0],0)+1);
            hm.put(interval[1],hm.getOrDefault(interval[1],0)-1);
        }
        int counter = 0;
        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            counter+=e.getValue();
            numOfRooms = Math.max(counter,numOfRooms);
        }
        return numOfRooms;
    }
}