class Solution {
    public long sumAndMultiply(int n) {
        int num = 0;
        int sumOfDig = 0;
        StringBuilder sb = new StringBuilder();
        while(n>0){
            if(n%10!=0){
                num+=num*10+n%10;
                sumOfDig+=n%10;
                sb.insert(0,n%10);
            }
            n/=10;
        }
        if(sb.length()==0) return 0l;
        return Long.parseLong(sb.toString())*sumOfDig;
    }
}