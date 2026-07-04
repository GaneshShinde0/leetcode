
class Solution {
    public int minScore(int n, int[][] roads) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] road:roads){
            graph.computeIfAbsent(road[0],x->new ArrayList<int[]>()).add(new int[]{road[1], road[2]});
            graph.computeIfAbsent(road[1],x->new ArrayList<int[]>()).add(new int[]{road[0], road[2]});
        }
        int res = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int[] arr: graph.get(curr)){
                res = Math.min(res, arr[1]);
                if(!visited.contains(arr[0])) queue.add(arr[0]);
            }
            visited.add(curr);
        }
        return res;
    }
}