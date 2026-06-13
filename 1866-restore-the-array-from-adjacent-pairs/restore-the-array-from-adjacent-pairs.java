class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int[] pair: adjacentPairs){
            int u = pair[0],v = pair[1];
            hm.computeIfAbsent(u,k->new HashSet<>()).add(v);
            hm.computeIfAbsent(v,k->new HashSet<>()).add(u);
        }
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[adjacentPairs.length+1];
        int start = 0, end = adjacentPairs.length;
        for(Map.Entry<Integer, HashSet<Integer>> e: hm.entrySet()){
            if(e.getValue().size()==1){
                res[end] = e.getKey();
                stk.add(e.getKey());
                visited.add(e.getKey());
                end--;
                break;
            }
        }
        while(!stk.isEmpty()){
            int top = stk.pop();
            for(int left: hm.get(top)){
                if(!visited.contains(left)){
                    visited.add(left);
                    stk.push(left);
                    res[end--]=left;
                }
            }
        }
        return res;
    }
}
class SolutionInitial{
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int[] pair: adjacentPairs){
            int u = pair[0],v = pair[1];
            hm.computeIfAbsent(u,k->new HashSet<>()).add(v);
            hm.computeIfAbsent(v,k->new HashSet<>()).add(u);
        }
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[adjacentPairs.length+1];
        int start = 0, end = adjacentPairs.length;
        for(Map.Entry<Integer, HashSet<Integer>> e: hm.entrySet()){
            if(e.getValue().size()==1 && start == 0){
                res[start]=e.getKey();
                stk.add(e.getKey());
                visited.add(e.getKey());
                start++;
            }else if(e.getValue().size()==1){
                res[end] = e.getKey();
                stk.add(e.getKey());
                visited.add(e.getKey());
                end--;
            }
        }
        while(!stk.isEmpty()){
            int top = stk.pop();
            for(int left: hm.get(top)){
                if(!visited.contains(left)){
                    visited.add(left);
                    stk.push(left);
                    res[end--]=left;
                }
            }
        }
        return res;
    }
}