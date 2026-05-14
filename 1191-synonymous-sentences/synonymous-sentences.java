class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, Set<String>> graph = new HashMap<>();
        for(int i=0;i<synonyms.size();i++){
            List<String> li = synonyms.get(i); 
            graph.computeIfAbsent(li.get(0),k->new HashSet<String>()).add(li.get(1));
            graph.computeIfAbsent(li.get(1),k->new HashSet<String>()).add(li.get(0));
        }
        List<String> result = new ArrayList<>();
        String[] words = text.split(" ");
        List<String> li = new ArrayList<>();
        dfs(result,graph,words,li, 0);
        Collections.sort(result);
        return result;
    }
    private void dfs(List<String> result, Map<String, Set<String>> graph, String[] words, List<String> li, int i){
        if(i==words.length) result.add(String.join(" ",li));
        else{
            // List<String> choices = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            Stack<String> stk = new Stack<>();
            stk.add(words[i]);
            while(!stk.isEmpty()){
                String curr = stk.pop();
                // choices.add(curr);
                visited.add(curr);
                if(!graph.containsKey(curr)) continue;
                for(String s:graph.get(curr)){
                    if(!visited.contains(s)){
                        stk.add(s);
                    }
                }
            }
            for(String s:visited){
                li.add(s);
                dfs(result,graph,words,new ArrayList<>(li),i+1);
                li.remove(li.size()-1);
            }
        }
    }
}