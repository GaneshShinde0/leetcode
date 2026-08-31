/*
cells = [0,1,0,1,1,0,0,1]







Day  1 = [0,1,1,0,0,0,0,0]
Day  2 = [0,0,0,0,1,1,1,0]
Day  3 = [0,1,1,0,0,1,0,0]
Day  4 = [0,0,0,0,0,1,0,0]
Day  5 = [0,1,1,1,0,1,0,0]
Day  6 = [0,0,1,0,1,1,0,0]
Day  7 = [0,0,1,1,0,0,0,0]
Day  8 = [0,0,0,0,0,1,1,0]
Day  9 = [0,1,1,1,0,0,0,0]
Day 10 = [0,0,1,0,0,1,1,0]
Day 11 = [0,0,1,0,0,0,0,0]
Day 12 = [0,0,1,0,1,1,1,0]
Day 13 = [0,0,1,1,0,1,0,0]
Day 14 = [0,0,0,0,1,1,0,0]
Day 15 = [0,1,1,0,0,0,0,0]

Day  1 = [0,1,1,0,0,0,0,0]
Day 15 = [0,1,1,0,0,0,0,0]
         ^^^^^^^^^^^^^^^^^
         SAME STATE

Cycles repeatin after 14 days .. i.e. if 

If you see above solulation, after every 7 count the rows are getting reversed.
Hence We have to calculate (n-1)%14 times only as the 
*/
class Solution {

    public int[] prisonAfterNDays(int[] cells, int n) {
        // The states repeat every 14 days.
        n = (n - 1) % 14 + 1;
        while (n-- > 0) {
            cells = perform(cells);
        }
        return cells;
    }

    private int[] perform(int[] cells) {
        int[] next = new int[8];
        for (int i = 1; i < 7; i++) {
            next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return next;
    }
}
class SolutionFails{
    public int[] prisonAfterNDaysFails(int[] cells, int n) {
        if(n==0) return cells;
        cells = perform(cells);
        cells[0]=0;
        cells[7]=0;
        int i=1;
        HashMap<String,Integer> hm = new HashMap<>();
        for(;i<n;i++){
            cells = perform(cells);
            System.out.println(Arrays.toString(cells));
            if(hm.containsKey(Arrays.toString(cells))) break;
            hm.put(Arrays.toString(cells),i);
        }
        int cycleLength = i-hm.get(Arrays.toString(cells));
        int remainingSteps = (n-i)%cycleLength;
        for(i=1;i<remainingSteps;i++){
            cells = perform(cells);
        }
        return cells;
    }
    private int[] perform(int[] cells){
        int[] copy = Arrays.copyOf(cells,8);
        for(int i=1;i<=6;i++){
            copy[i] = cells[i-1]==cells[i+1]?1:0;
        }
        return copy;
    }
}