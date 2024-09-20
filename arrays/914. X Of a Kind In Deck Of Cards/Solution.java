class Solution {
    public boolean hasGroupsSizeXWrong(int[] deck) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i:deck){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int prev=hm.get(deck[0]);
        if(prev<=1) return false;
        for(int e:hm.values()){
            if(e%prev!=0) return false;
        }
        return true;
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
        for (int i : count.values()) res = gcd(i, res);
        return res > 1;
    }
    
    public int gcd(int a, int b){
        return b>0?gcd(b,a%b):a;
    }
}
