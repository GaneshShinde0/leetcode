class Solution {
    public long countSubstrings(String s, char c) {
        long count =0;
        for(char temp:s.toCharArray()){
            if(c==temp) count++;
        }
        return summation(count);
    }
    public long summation(long a){
        return a*(a+1)/2;
    }
    public int factorial(int a){
        if(a<2) return a;
        int res=1;
        for(int i=2;i<=a;i++){
            res*=i;
        }
        return res;
    }
}
