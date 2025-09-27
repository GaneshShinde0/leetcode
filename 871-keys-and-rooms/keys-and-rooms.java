class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int n = rooms.size();
        // for(int i:rooms.get(0)){
        //     q.add(i);
        // }
        while(!q.isEmpty()){
            List<Integer> li = rooms.get(q.poll());
            for(int j=0;j<li.size();j++){
                if(!set.contains(li.get(j))){
                    q.add(li.get(j));
                    set.add(li.get(j));
                }
            }
        }
        System.out.println(set);
        for(int i=1;i<n;i++){
            if(!set.contains(i)) return false;
        }
        return true;
    }
}