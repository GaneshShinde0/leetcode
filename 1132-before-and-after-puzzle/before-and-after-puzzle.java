class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Set<String> result = new HashSet<>();
        int n = phrases.length;
        for(int i=0;i<n;i++){
            String[] curr = phrases[i].split(" ");
            for(int j=0;j<n;j++){
                if(i==j) continue;
                String[] sub = phrases[j].split(" ");
                if(curr[curr.length-1].equals(sub[0])){
                    StringBuilder str = new StringBuilder(phrases[i]);
                    str.append(" ");
                    for(int k=1;k<sub.length;k++){
                        str.append(sub[k]);
                        str.append(" ");
                    }
                    str.deleteCharAt(str.length()-1);
                    result.add(str.toString());
                }
            }
        }
        List<String> li = new ArrayList<>(result);
        Collections.sort(li);
        return li;
    }
}