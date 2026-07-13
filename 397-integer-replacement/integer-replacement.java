class Solution {
    public int integerReplacement(int n) {
        HashMap<Long, Integer> hm = new HashMap<>();
        return recurse(n, hm);
    }
    private int recurse(long n, HashMap<Long, Integer> hm){
        if(n==1) return 0;
        if(hm.containsKey(n)) return hm.get(n);
        if(n%2==0) return 1+recurse(n/2,hm);
        int add = 1+recurse(n+1,hm);
        int sub = 1+recurse(n-1,hm);
        hm.put(n, Math.min(add,sub));
        return hm.get(n);
    }
}