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
        Set<String> resSet = new HashSet<>();
        Set<String> dictSet = new HashSet<>(List.of(dictionary));
        Stack<WordArrEdits> stk = new Stack<>();
        for(int i= queries.length-1;i>=0;i--){
            String s = queries[i];
            stk.add(new WordArrEdits(s,s.toCharArray(),0));
        }
        while(!stk.isEmpty()){
            WordArrEdits curr = stk.pop();
            String word = curr.word;
            char[] wordArr = curr.arr;
            int edits = curr.edits;
            if(dictSet.contains(new String(wordArr))){
                if(!resSet.contains(word)){
                    res.add(word);
                }
                resSet.add(word);
                continue;
            }
            for(int i=0;i<len;i++){
                for(int j=0;j<26;j++){
                    char temp = wordArr[i];
                    wordArr[i]=(char) (j+'a');
                    if(edits==1 && !dictSet.contains(new String(wordArr))) continue;
                    char[] arr = new char[len];
                    arr = Arrays.copyOf(wordArr,len);
                    stk.add(new WordArrEdits(word, arr, edits+1));
                    wordArr[i]=temp;
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
        }
        return diff<=2;
    }
}