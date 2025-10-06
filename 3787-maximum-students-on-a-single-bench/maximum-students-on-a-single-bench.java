class Solution {
    public int maxStudentsOnBenchInitial(int[][] students) {
        Map<Integer, TreeSet<Integer>> hm = new HashMap<>();
        int res = 0;
        for(int[] s:students){
            hm.computeIfAbsent(s[1],k->new TreeSet<Integer>()).add(s[0]);
            res = Math.max(res,hm.get(s[1]).size());
        }
        return res;
    }
    
    public int maxStudentsOnBench(int[][] students) {
        Map<Integer, HashSet<Integer>> hm = new HashMap<>();
        int res = 0;
        for(int[] s:students){
            hm.computeIfAbsent(s[1],k->new HashSet<Integer>()).add(s[0]);
            res = Math.max(res,hm.get(s[1]).size());
        }
        return res;
    }

}