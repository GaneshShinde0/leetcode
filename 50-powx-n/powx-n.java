class Solution {
    HashMap<Integer, Double> hm = new HashMap<>();
    public double myPowInitial(double x, int n) {
        hm.put(0,1.0);
        hm.put(1,x);
        hm.put(-1,1/x);
        return helper(x,n);
    }
    private double helper(double x, int n){
        if(hm.containsKey(n)) return hm.get(n);
        double half = myPow(x,n/2);
        double full=half*half;
        if(n%2==1||n%2==-1){
            full*=hm.get(n%2);
        }
        hm.put(n,full);
        return full;
    }
    
    public double myPow(double x, int n){
        return myPow(x,(long) n);
    }
    public double myPow(double x, long n) {
       if(n==0) return 1;
       if(n<0){
            n = -1*n;
            x=1.0/x;
       }
       // Perform Binary Exponentiation
       double result = 1;
       while(n!=0){
            if(n%2==1){
                result = result*x;
                n-=1;
            }
            x = x*x;
            n = n/2;
       }
       return result;

    }
}