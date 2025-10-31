class Solution {
    // As question is asking after one valid move we just have to give all strings that can be formed by replacing any ++ with -- based on initial string.
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        for(int i=-1; (i=s.indexOf("++",i+1))>=0;){
            list.add(s.substring(0,i)+"--"+s.substring(i+2));
        }
        return list;
    }
}