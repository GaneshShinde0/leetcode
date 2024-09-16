class Solution {
    public int findMinDifference(List<String> timePoints) {
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
