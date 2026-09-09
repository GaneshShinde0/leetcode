class Solution {
    public long countCommas(long n) {
        long commas = 0;
        if(n>999){
            commas += n-999;
        }
        if(n>999999l){
            commas += n-999999l;
        }
        if(n>999999999l){
            commas += n-999999999l;
        }
        if(n>999999999999l){
            commas += n-999999999999l;
        }
        if(n>999999999999999l){
            commas += n-999999999999999l;
        }
        return commas;
        
    }
}
