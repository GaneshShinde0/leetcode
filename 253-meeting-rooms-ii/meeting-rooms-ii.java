class Solution {
    public int minMeetingRoomsInitial40Min(int[][] intervals) {
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
    public int minMeetingRooms(int[][] intervals) {
        int length = intervals.length;
        int[] start = new int[length];
        int[] end = new int[length];
        for(int i=0; i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0, j=0, count=0;
        while(i<length && j<length){
            if(start[i]<end[j]){
                count++;
                i++;
            }else{
                i++; j++;
            }
        }
        return count;
    }
}