class Solution {
    public int kthFactorOofN(int n, int k) {
        int counter=0;
        for(int i=1;i<=n;i++){
            if(n%i==0) counter++;
            if(counter==k) return i;
        }
        return -1;
    }

    public int kthFactor(int n, int k) {
        int counter=0;
        for(int i=1;i<Math.sqrt(n);i++){
            if(n%i==0) ++counter;
            if(counter==k) return i;
        }
        for(int i=(int)Math.sqrt(n);i>=1;i--){
            if(n%(n/i)==0) counter++;
            if(counter==k) return n/i;
        }
        return -1;
    }
}
