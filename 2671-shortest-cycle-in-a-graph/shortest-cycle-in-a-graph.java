class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e:edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int inf = 10000, res = inf;
        
        Function<Integer, Integer> root = i -> {
            List<Integer> dis = new ArrayList<>(Collections.nCopies(n,inf));
            dis.set(i,0);
            int temp = inf;
            Queue<Integer> bfs = new LinkedList<>(Arrays.asList(i));
            while(!bfs.isEmpty()){
                i = bfs.poll();
                for(int j:graph.get(i)){
                    if(dis.get(j)==inf){
                        dis.set(j, 1+dis.get(i));
                        bfs.offer(j);
                    }else if(dis.get(i)<=dis.get(j)){
                        temp = Math.min(temp,dis.get(i)+dis.get(j)+1);
                    }
                }
            }
            return temp;
        };

        for(int i=0;i<n;i++) res = Math.min(res, root.apply(i));
        return res<inf?res:-1;
    }
}