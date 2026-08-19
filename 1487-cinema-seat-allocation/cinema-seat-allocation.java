class Solution{
    public int maxNumberOfFamilies(int n, int[][] reservedSeats){
        Map<Integer, Integer> rowWiseSeats = new HashMap<>();
        for(int[] reserved: reservedSeats){
            int row = reserved[0], col = reserved[1];
            rowWiseSeats.put(row, rowWiseSeats.getOrDefault(row,0)|(1<<col));
        }
        int res = 0;
        for(int row:rowWiseSeats.keySet()){
            int reserved = rowWiseSeats.get(row);
            int cnt = 0;
            if((reserved&60)==0) cnt+=1; // Checks if seats 2,3,4,5 are available
            if((reserved&960)==0) cnt+=1; // Check if seats 6,7,8,9 are available.
            if((reserved&240)==0 && cnt==0) cnt = 1; // Checks if seat 4,5,6,7 are available
            res+=cnt;
        }
        return res+(n-rowWiseSeats.size())*2;
    }
}
class SolutionInitial {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        });
        int resSeatCount = reservedSeats.length;
        int rowPtr = 0, res=0, rowsVisited=0;
        while(rowPtr<resSeatCount){
            boolean left = true, right = true,mid=true;
            int currRow = reservedSeats[rowPtr][0];
            while(rowPtr<resSeatCount && currRow == reservedSeats[rowPtr][0]){
                int seat = reservedSeats[rowPtr][1];
                if(seat>=2 && seat<=5) left  = false;
                if(seat>=6 && seat<=9) right  = false;
                if (seat>=4 && seat<=7) mid = false;
                rowPtr++;
            }
            if(left && right) res+=2;
            else if(left||right||mid) res+=1;
            rowsVisited++;
        }
        return res+(n-rowsVisited)*2;
    }
}