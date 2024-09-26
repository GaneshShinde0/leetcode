class MyCalendar {
    //
    /*
    private List<int[]> li;
    public MyCalendar() {
        li = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int i=0;i<li.size();i++){
            if((li.get(i)[0]<=start && li.get(i)[1]>start)||(li.get(i)[0]<end && li.get(i)[1]>=end||(start<=li.get(i)[0] && end>=li.get(i)[1]))){
                return false;
            }
        }
        li.add(new int[]{start,end});
        return true;
    }
    */
    /*
    List<int[]> calendar;
    MyCalendar(){
        calendar = new ArrayList();
    }

    public boolean book(int start, int end){
        for(int[] range:calendar){
            // If previous start is before end
            // and previous end is after start
            if(range[0]<end && range[1]>start){
                return false;
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }
    */
    TreeMap<Integer,Integer> calendar;

    MyCalendar(){
        calendar = new TreeMap();
    }

    public boolean book(int start, int end){
        Integer prev = calendar.floorKey(start), next = calendar.ceilingKey(start);
        if(((prev==null||calendar.get(prev)<=start))&&
            (next==null || end<=next)){
                calendar.put(start, end);
                return true;
            }
        return false;
    }
}
