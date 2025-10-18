class Solution {
    public int[][] indexPairs(String text, String[] words) {
        Set<String> set = new HashSet<>();
        List<int[]> res = new ArrayList<>();
        for(String word:words){
            set.add(word);
        }
        for(int i=0;i<text.length();i++){
            for(int j=i+1;j<=text.length();j++){
                if(set.contains(text.substring(i,j))){
                    res.add(new int[]{i,j-1});
                }
            }
        }
        return res.toArray(new int[0][]);
    }
}