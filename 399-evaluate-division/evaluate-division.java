class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String,Map<String,Double>> edgeToWeight = new HashMap<>();
        int n = equations.size();
        for(int i=0;i<n;i++){
            edgeToWeight.computeIfAbsent(equations.get(i).get(0),k->new HashMap<String,Double>());
            edgeToWeight.get(equations.get(i).get(0)).put(equations.get(i).get(1),values[i]);
            
            edgeToWeight.computeIfAbsent(equations.get(i).get(1),k->new HashMap<String,Double>());
            edgeToWeight.get(equations.get(i).get(1)).put(equations.get(i).get(0),1/values[i]);

        }
        System.out.println(edgeToWeight);
        double[] res = new double[queries.size()];
        // Solve each query
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!edgeToWeight.containsKey(start) || !edgeToWeight.containsKey(end)) {
                res[i] = -1.0;
            } else if (start.equals(end)) {
                res[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                res[i] = dfs(edgeToWeight, start, end, 1.0, visited);
            }
        }

        return res;
    }

    // DFS helper: try to find a path from 'curr' to 'target', multiplying ratios along the way
    private double dfs(Map<String, Map<String, Double>> graph, String curr, String target, double product, Set<String> visited) {
        visited.add(curr);
        if (graph.get(curr).containsKey(target)) {
            return product * graph.get(curr).get(target);
        }

        for (Map.Entry<String, Double> neighbor : graph.get(curr).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(graph, neighbor.getKey(), target, product * neighbor.getValue(), visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        return -1.0;
    }
}