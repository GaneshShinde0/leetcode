class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int curr = 0;
        int both = 0;
        int res = 0;
        for(char c:moves.toCharArray()){
            if(c=='L') curr--;
            else if(c=='R') curr++;
            else{
                both++;
            }
            res = Math.abs(curr)+both;
        }
        return res;
    }
}