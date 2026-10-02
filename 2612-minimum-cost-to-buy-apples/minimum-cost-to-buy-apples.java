class Solution {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        // Store the graph as a list of lists
        // Each element of the outer list represents a city,
        // and each inner list contains pairs of neighboring city and its cost
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        
        // Add each road to the graph using adjacency lists
        // Store each city at `graph[city - 1]`
        for (int[] road : roads) {
            int cityA = road[0] - 1, cityB = road[1] - 1, cost = road[2];
            graph.get(cityA).add(new Pair<Integer, Integer>(cityB, cost));
            graph.get(cityB).add(new Pair<Integer, Integer>(cityA, cost));
        }

        // Store the cost to buy an apple in each city 
        // without traveling in the result
        long[] result = new long[n];
        for (int startCity = 0; startCity < n; startCity++) {
            result[startCity] = appleCost[startCity];
        }
        
        // Initialize the min heap (priority queue) with each starting city
        // Each element of the heap is a pair with the cost and city
        Queue<Pair<Long, Integer>> heap = new PriorityQueue<>((a, b) -> 
                Long.compare(a.getKey(), b.getKey()));
        for (int startCity = 0; startCity < n; startCity++) {
            heap.add(new Pair<>((long)appleCost[startCity], startCity));
        }
        
        // Find the minimum cost to buy an apple starting in each city
        while (!heap.isEmpty()) {
            Pair<Long, Integer> current = heap.poll();
            long totalCost = current.getKey();
            int currCity = current.getValue();
            
            // If we have already found a path to buy an apple
            // for cheaper than the local apple cost, skip this city
            if (result[currCity] < totalCost)
                continue;
            
            // Add each neighboring city to the heap if it is cheaper to
            // start there, travel to the current city and buy an apple 
            // than buy in the neighboring city
            for (Pair<Integer, Integer> next : graph.get(currCity)) {
                int neighbor = next.getKey(), cost = next.getValue();
                if (result[neighbor] > result[currCity] + (k + 1) * cost) {
                    result[neighbor] = result[currCity] + (k + 1) * cost;
                    heap.add(new Pair<Long, Integer>(result[neighbor], neighbor));
                }
            }
        }
        return result;
    }
}