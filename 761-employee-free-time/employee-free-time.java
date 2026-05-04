/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
/*
[[1,2],[5,6],[1,3],[4,10]]
[[1,2],[1,3],[5,6],[4,10]]
[[1,2],[1,3],[4,10],[5,6]]
*/
import java.util.Collection;

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        List<Interval> allSched = schedule.stream().flatMap(Collection::stream).collect(Collectors.toList());
        Collections.sort(allSched,(a,b)->{
            if(a.start!=b.start) return Integer.compare(a.start,b.start);
            return Integer.compare(a.end,b.end);
        });
        int currStart = allSched.get(0).start;
        int prevEnd = allSched.get(0).end;
        for(int i=1;i<allSched.size();i++){
            Interval curr = allSched.get(i);
            if(prevEnd<curr.start){
                result.add(new Interval(prevEnd,curr.start));
            }
            prevEnd = Math.max(prevEnd,curr.end);
        }
        return result;
    }
}

/*
0100100000
0110000000
0000111111
*/
