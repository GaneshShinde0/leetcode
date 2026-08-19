class Solution {
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