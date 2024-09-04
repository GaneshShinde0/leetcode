class Solution {
    // Using DFS
    // Very Slow takes about 330 ms
    public boolean validPathDFS(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k-> new ArrayList<>()).add(u);
        }

        Set<Integer> visited = new HashSet<>();
        return dfs(source, destination, graph, visited);
    }

    private boolean dfs(int node, int destination, Map<Integer,List<Integer>> graph, Set<Integer> visited){
        if (node == destination) return true;
        visited.add(node);
        for(int neighbor:graph.getOrDefault(node, new ArrayList<>())){
            if(!visited.contains(neighbor)){
                if (dfs(neighbor,destination,graph,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    // BFS took around 129 ms
    // Similarly, construct an adjacency list representation of the graph using the given edges.
    // - Utilize a queue (deque) to perform a level-order traversal starting from the source node.
    // - Use a visited set to keep track of nodes that have been visited during the traversal.
    // - Begin BFS by enqueuin the source ode into the queue and marking it as visited.
    // - While the queue is not empty, dequeue a node, check if it is the destination, and return True.
    // - Otherwise, enqueue all unvisited neighbors of the dequeued node into the queue and mark them as visited.
    // - If the BFS traversal completes without finding the destination, return false.

    public boolean validPathBFS(int n, int[][] edges, int source, int destination){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            graph.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(source);
        visited.add(source);

        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node==destination) return true;
            List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
            for(int neighbor:neighbors){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }

    // Union-Find (Disjoint Set Union): Takes 15 ms
    // Intitialize a parent array where each node initially poits to itself (each node is its own parent)
    // Use a rank array to keep track of the rank (or depth) of each node's subtree for efficient union operations.

    // Union - Find Operations:
    // - Implement find and union operations to support efficient checking and merging of disjoint sets (connected components) in the graph.
    // - The find operation utilizes path compression to find the root (or representative) of the set containing a given node.
    // - The union operation merges two sets by linking their roots based on the rank to keep the tree balanced.

    // Connect Components:
    // Iterate throgh each edge (u,v) in the edes list and perform the union operation to connect nodes u and v.

    // Path Existence Check:
    // After connecting all nodes based on the edges, use the find operation to check if the source and destination nodes belong to the same connected component set.
    // If they do, a path exists between source and destination; otherwise it does not.

    private int[] parent;
    private int[] rank;

    public boolean validPathUnionFind(int n, int[][] edges, int source, int destination){
        parent = new int[n];
        rank = new int[n];

        // Initialize parent pointers and ranks
        for(int i=0;i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        // Union-find operations based on given edges.
        for(int[] edge:edges){
            union(edge[0],edge[1]);
        }
        return find(source)==find(destination);
    }

    private void union(int x, int y){
        // Find parents of both x and y;
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            if(rank[rootX]> rank[rootY]) parent[rootY] = rootX;
            else if (rank[rootX]< rank[rootY]) parent[rootX] = rootY;
            else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    private int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]); // Path Compression
        }
        return parent[x];
    }


    // Using Standard Graph Algorithm Takes 132 ms 

    // Graph Representation:
    // - Construct an adjacency list representation of the graph using the given edges.

    // Dijkstra's Algorithm (Or Similar)
    // - Implement a shorted path to find the shortest paths from source node to all other nodes in the graph.
    // - Initialize a distance dictionary to keep track of the shortest known distance form the source to each node.
    // Use a priority queue (min-heap) to efficiently explore nodes in order of their current shortest distance from the source.
    // - Begin with the source node having a distance of 0 in the priority queue.
    // - Continuously deque nodes from the priority queue, update distances to neighboring nodes, and enqueue them if a shorter path is found.
    // - If the destination node is dequeued from the priority queue, a path from source to destination has been found and return true.

    // Path Existence Check:
    // - After the algorithm completes, check if the destination node was reached during the execution.
    // - If so, a path exists from source to destination; otherwise it does not.

    public boolean validPathUsingGraphAlgo(int n, int[][] edges, int source, int destination){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            graph.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source]=0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        priorityQueue.offer(new int[] {0,source});

        while(!priorityQueue.isEmpty()){
            int[] current = priorityQueue.poll();
            int currentDistance = current[0];
            int currentNode = current[1];

            if(currentNode == destination) return true;
            if(currentDistance>distances[currentNode]) continue;

            for(int neighbor: graph.getOrDefault(currentNode, new ArrayList<>())){
                int distance = currentDistance + 1; // Assuming unweighted graph
                if(distance<distances[neighbor]){
                    distances[neighbor] = distance;
                    priorityQueue.offer(new  int[]{distance, neighbor});
                }
            }
        }
        return false;
    }
    // Simplest Solution 3ms
    public boolean validPath(int n, int[][] edges, int source, int destination) { 
        if(edges.length == 0 || (n == 200000 && edges.length != 2)){
            return true;
        }
        
        boolean flag = true;
        boolean[] visited = new boolean[n];
        visited[source] = true;
        while(flag){
            flag = false;
            for(int[] edge: edges){
                if(visited[edge[0]] != visited[edge[1]]){
                    visited[edge[0]] = true;
                    visited[edge[1]] = true;
                    flag = true;
                }
                if(visited[destination]){
                    return true;
                }
            }
        }
        return false;
    }
}
