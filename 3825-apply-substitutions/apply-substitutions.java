class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        StringBuilder sb = new StringBuilder(text);
        while(sb.indexOf("%")!=-1){
            for(List<String> li: replacements){
                int index= sb.indexOf("%"+li.get(0)+"%");
                if(index==-1) continue;
                sb.replace(index, index+3,li.get(1));
            }
        }
        return sb.toString();
    }
}