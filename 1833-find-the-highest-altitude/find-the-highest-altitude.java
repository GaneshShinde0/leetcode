class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0, curr = 0;
        for(int g:gain){
            curr+=g;
            res = Math.max(res,curr);
        }
        return res;
    }
}