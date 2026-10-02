class Solution {

    //represents a subtree
    private class Node {
        private long val = 0; //the number of paths that traverse between this node and its parent
        private final Map<Integer, Integer> map = new HashMap<>(); //the frequency of each group in this subtree
        
        //inserts 'count' amount of nodes from 'group', updates the amount of paths for the given group
        private void insert(int group, int count) {
            long newVal = map.merge(group, count, Integer::sum); //newVal = current freq of 'group' in the subtree
            long oldVal = newVal - count; //oldVal = prev freq of 'group'

            val -= oldVal * (freq[group] - oldVal); //subtract old path count for 'group'
            val += newVal * (freq[group] - newVal); //add new path count for 'group'
        }

        private void merge(Node small) { //merge a smaller map into this one
            for(Map.Entry<Integer, Integer> entry : small.map.entrySet()) insert(entry.getKey(), entry.getValue());
        }
    }



    private int[][] adj;
    private int[] group, freq;
    private long total = 0;
    public long interactionCosts(int n, int[][] edges, int[] group) {
        this.group = group;
        this.adj = buildGraph(edges, n); //build adj list

        this.freq = new int[n];
        for(int i = 0; i < n; i++) freq[--group[i]]++; //make groups 0-indexed and count the frequency of each group

        dfs(n / 2, -1);
        return total;
    }



    //for each node, counts the total number of paths that must travel between the node and its parent
    private Node dfs(int index, int prev) {
        Node current = new Node(); //current subtree
        current.insert(group[index], 1); //starts with just the current node

        for(int i : adj[index]) {
            if(i == prev) continue;

            Node child = dfs(i, index); //get child subtree

            //child.val = number of valid paths passing between the child node and the current node
            total += child.val; //add number of paths to the final cost
            
            if(child.map.size() > current.map.size()) { //small to large merging
                Node temp = current;
                current = child;
                child = temp;
            }
            current.merge(child); //merge the child and the current subtree, and update the current path count
        }

        return current;
    }




    //optimized adj list template
    private static int[][] buildGraph(int[][] edges, int n) {
        int[] degree = new int[n];
        for(int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        int[][] graph = new int[n][];
        for(int i = 0; i < n; i++) graph[i] = new int[degree[i]];
        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a][--degree[a]] = b;
            graph[b][--degree[b]] = a;
        }
        return graph;
    }
}