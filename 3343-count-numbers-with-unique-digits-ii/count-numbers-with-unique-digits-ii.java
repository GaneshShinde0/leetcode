class Solution {
    public int numberCount(int a, int b) {
        int res = 0;
        for(int i=a;i<=b;i++){
            if(hasUniques(i)) res++;
        }
        return res;
    }
    boolean hasUniques(int n){
        int temp =0;
        while(n>0){
            int dig = n%10;
            if((temp>>dig & 1) == 1) return false;
            temp = temp | (1<<dig);
            n = n/10;
        }
        return true;
    }
}