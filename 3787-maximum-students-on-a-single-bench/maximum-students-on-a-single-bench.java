class Solution {
    public int maxStudentsOnBench(int[][] students) {
        Map<Integer, TreeSet<Integer>> hm = new HashMap<>();
        int res = 0;
        for(int[] s:students){
            hm.computeIfAbsent(s[1],k->new TreeSet<Integer>()).add(s[0]);
            res = Math.max(res,hm.get(s[1]).size());
        }
        return res;
    }
}