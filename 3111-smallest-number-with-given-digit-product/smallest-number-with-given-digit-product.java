class Solution {
    public String smallestNumber(long n) {
        if(n<10) return n+"";
        int[] count = new int[10];
        int i=9;
        while(n>1 && i>1){
            while(n%i==0){
                n/=i;
                count[i]++;
            }
            i--;
        }
        if(n!=1) return "-1";
        StringBuilder sb = new StringBuilder();
        for(i=2;i<10;i++){
            sb.append((i+"").repeat(count[i]));
        }
        return sb.toString();
    }
}