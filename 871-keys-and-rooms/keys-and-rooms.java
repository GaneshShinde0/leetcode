class Solution {
    public boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        set.add(0);
        int n = rooms.size();
        while(!q.isEmpty()){
            List<Integer> li = rooms.get(q.poll());
            for(int j=0;j<li.size();j++){
                if(!set.contains(li.get(j))){
                    q.add(li.get(j));
                    set.add(li.get(j));
                }
            }
        }
        return set.size()==rooms.size();
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(0, rooms, visited);
        return visited.size() == rooms.size();
    }

    private void dfs(int room, List<List<Integer>> rooms, Set<Integer> visited) {
        if (visited.contains(room)) return; // already visited
        visited.add(room);
        for (int key : rooms.get(room)) {
            dfs(key, rooms, visited); // go deeper for each key
        }
    }
}