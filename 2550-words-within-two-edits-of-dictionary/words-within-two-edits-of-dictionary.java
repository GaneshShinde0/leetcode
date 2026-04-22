class Solution {
    private static class WordArrEdits{
        String word;
        char[] arr;
        int edits;
        WordArrEdits(String word, char[] arr, int edits){
            this.word = word;
            this.arr = arr;
            this.edits = edits;
        }
    }
    public List<String> twoEditWordsInitial(String[] queries, String[] dictionary) {
        int len = queries[0].length();
        List<String> res = new ArrayList<>();
        Set<String> dictSet = new HashSet<>(Arrays.asList(dictionary));

        for (String q : queries) { 
            Stack<WordArrEdits> stk = new Stack<>();
            stk.add(new WordArrEdits(q, q.toCharArray(), 0));
            Set<String> visited = new HashSet<>(); 
            boolean found = false;

            while (!stk.isEmpty()) {
                WordArrEdits curr = stk.pop();
                String currentMutation = new String(curr.arr);
                if (dictSet.contains(currentMutation)) {
                    res.add(q);
                    found = true;
                    break; 
                }

                if (curr.edits < 2) {
                    for (int i = 0; i < len; i++) {
                        char originalChar = curr.arr[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == originalChar) continue;
                            
                            curr.arr[i] = c;
                            String nextWord = new String(curr.arr);
                            if (!visited.contains(nextWord)) {
                                visited.add(nextWord);
                                stk.add(new WordArrEdits(q, curr.arr.clone(), curr.edits + 1));
                            }
                        }
                        curr.arr[i] = originalChar;
                    }
                }
            }
        }
        return res;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for(String q:queries){
            for(String d:dictionary){
                if(canChange(q,d)){
                    result.add(q);
                    break;
                }
            }
        }
        return result;
    }
    private boolean canChange(String source, String target){
        int diff = 0;
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)!=target.charAt(i)) diff++;
            if(diff>2) return false;
        }
        return true;
    }
}