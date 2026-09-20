class Solution {
    public int clumsy(int n) {
        int res = 0, sign = 1;
        double doubleRes = 0;
        while(n>=4){
            doubleRes = doubleRes+sign*n*(n-1)/(n-2)+(n-3);
            sign = -1;
            n-=4;
        }
        res = (int) doubleRes;
        if(n==3) return res+sign*3*2/1;
        else if(n==2) return res+sign*2*1;
        else if(n==1) return res+sign*1;
        else return res;
    }
}