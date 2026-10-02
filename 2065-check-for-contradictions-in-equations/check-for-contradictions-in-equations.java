class Solution {
    private record Pair(String variable, Double value){}
    public boolean checkContradictions(List<List<String>> equations, double[] values) {
        var graph = new HashMap<String, List<Pair>>();
        var variables = new HashSet<String>();

        // Build the graph
        for(int eq = 0; eq < equations.size(); eq++) {
            var equation = equations.get(eq);
            var value = values[eq];
            var a = equation.get(0);
            var b = equation.get(1);

            if(!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }

            if(!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }

            graph.get(a).add(new Pair(b, value));
            graph.get(b).add(new Pair(a, 1 / value));
            variables.add(a);
            variables.add(b);
        }

        var visited = new HashMap<String, Double>();
        for(var variable : variables) {
            if(visited.containsKey(variable)) {
                continue;
            }
            // Check if the system is consistent by traversing the graph (chaining equations through multiplication)
            if(!dfs(variable, 1d, graph, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(String variable, Double value, Map<String, List<Pair>> graph, Map<String, Double> visited) {
        if(visited.containsKey(variable)) {
            return Math.abs(value - visited.get(variable)) < 0.00001;
        }
        
        visited.put(variable, value);

        for(var neighbor : graph.get(variable)) {
            var neighborVariable = neighbor.variable;
            var neighborValue = neighbor.value;
            if(!dfs(neighborVariable, value * neighborValue, graph, visited)) {
                return false;
            }
        }

        return true;
    }
}