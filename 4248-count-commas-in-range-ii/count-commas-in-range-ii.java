class Solution {
    public long countCommas(long n) {
        long commas = 0;
        if(n>999){
            commas += Math.max(0,n-999);
        }
        if(n>999999l){
            commas += Math.max(0,n-999999l);
        }
        if(n>999999999l){
            commas += Math.max(0,n-999999999l);
        }
        if(n>999999999999l){
            commas += Math.max(0,n-999999999999l);
        }
        if(n>999999999999999l){
            commas += Math.max(0,n-999999999999999l);
        }
        return commas;
        
    }
}