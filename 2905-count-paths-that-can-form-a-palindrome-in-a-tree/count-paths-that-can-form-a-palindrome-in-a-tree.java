class Solution {
    private List<int[]>[] graph;
    private Map<Integer, Integer> xorCount = new HashMap<>();
    private long answer;
    public long countPalindromePaths(List<Integer> parent, String s) {
        int nodeCount = parent.size();

        graph = new List[nodeCount];
        Arrays.setAll(graph, index-> new ArrayList<>());
        xorCount.put(0,1);

        for(int childNode = 1; childNode<nodeCount; ++childNode){
            int parentNode = parent.get(childNode);
            int characterBitmask = 1<<(s.charAt(childNode)-'a');
            graph[parentNode].add(new int[] {childNode, characterBitmask});
        }
        dfs(0,0);
        return answer;
    }

    private void dfs(int currentNode, int currentXor){
        for(int[] edge:graph[currentNode]){
            int childNode = edge[0];
            int characterBitmask = edge[1];

            int newXor = currentXor ^ characterBitmask;

            answer+=xorCount.getOrDefault(newXor,0);

            for(int bitPosition =0; bitPosition<26; bitPosition++){
                int targetXor = newXor ^ (1<<bitPosition);
                answer+=xorCount.getOrDefault(targetXor, 0);
            }
            xorCount.merge(newXor, 1, Integer::sum);
            dfs(childNode, newXor);
        }
    }
}