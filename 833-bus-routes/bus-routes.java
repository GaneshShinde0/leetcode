class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target) return 0;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int stop:routes[i]){
                // All the routes (or buses) that have this stop 
                ArrayList<Integer> route = graph.getOrDefault(stop,new ArrayList<>());
                route.add(i);
                graph.put(stop, route);
            }
        }

        if(graph.get(source)==null||graph.get(target)==null) return -1;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> vis = new HashSet<Integer>(graph.size());
        
        for(int route:graph.get(source)){
            queue.add(route);
            vis.add(route);
        }

        int busCount = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int route = queue.poll();
                for(int stop:routes[route]){
                    if(stop==target) return busCount;
                    for(int nextRoute: graph.get(stop)){
                        if(!vis.contains(nextRoute)){
                            vis.add(nextRoute);
                            queue.add(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}