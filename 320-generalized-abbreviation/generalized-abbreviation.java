class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        backtrack(0,0, word, "",result);
        return result;
    }
    private void backtrack(int pos, int count, String word, String curr, List<String> result){
        if(pos == word.length()){
            if(count>0) curr+=count;
            result.add(curr);
        }else{
            backtrack(pos+1, count+1, word, curr,result);
            backtrack(pos+1, 0, word, curr+(count>0?count:"")+word.charAt(pos),result);
        }
    }
}