class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int res = 1;
        Set<Integer> s = new HashSet<>();
        for(int i: rolls){
            s.add(i);
            if(s.size()==k){
                res++;
                s.clear();
            }
        }
        return res;
    }
}