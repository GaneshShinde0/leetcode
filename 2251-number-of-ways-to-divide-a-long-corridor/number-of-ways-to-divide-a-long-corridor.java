class Solution {
    private static final int MOD = 1_000_000_007;
    public int numberOfWays(String corridor) {
        int s = 0, p = 0;
        long res=1l;
        List<Integer> seats = new ArrayList<>();
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S') seats.add(i);
        }
        if(seats.size()%2==1||seats.size()<2) return 0;
        for(int i=2;i<seats.size();i+=2){
            res = (res*(seats.get(i)-seats.get(i-1)))%MOD;
        }
        return (int) res;
    }
}