class Solution {
    boolean[] done;
    Integer[] parent;
    HashMap<Integer, Set<Integer>> xMap = new HashMap<>();
    HashMap<Integer, Set<Integer>> yMap = new HashMap<>();
    int[][] points;
    public int maxActivated(int[][] points) {
        this.points = points;
        int n = points.length;
        for(int i=0;i<n;i++){
            xMap.computeIfAbsent(points[i][0], s->new HashSet<Integer>()).add(i);
            yMap.computeIfAbsent(points[i][1], s->new HashSet<Integer>()).add(i);
        }
        done = new boolean[n];
        parent = new Integer[n];
        for(int i=0;i<n;i++){
            if(!done[i]) connect(i);
        }
        HashMap<Integer, Integer> counts = new HashMap<>();
        for(int x:parent){
            counts.put(x,counts.getOrDefault(x,0)+1);
        }
        List<Integer> li = new ArrayList<>(counts.values());
        Collections.sort(li);
        /*Case 1 (2 or more components): To maximize points, the code takes the two largest components and assumes the single "added point" can be placed at an intersection (x,y) that merges these two groups. The result is size_of_largest + size_of_second_largest + 1 (the +1 is the newly added point).
        */
        if(li.size()>=2) return li.get(li.size()-1)+li.get(li.size()-2)+1;
        else return li.get(li.size()-1)+1;
    }

    private void connect(int start){
        Queue<Integer> queue= new LinkedList<>();
        done[start] = true;
        parent[start] = start;
        queue.offer(start);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int index:xMap.get(points[curr][0])){
                if(!done[index]){
                    done[index]=true;
                    parent[index]= start;
                    queue.offer(index);
                }
            }
            xMap.get(points[curr][0]).clear();
            for(int index:yMap.get(points[curr][1])){
                if(!done[index]){
                    done[index]=true;
                    parent[index]= start;
                    queue.offer(index);
                }
            }
            yMap.get(points[curr][1]).clear();
        }
    }
}