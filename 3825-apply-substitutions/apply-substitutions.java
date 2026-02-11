class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        while(text.indexOf("%")!=-1){
            for(List<String> li: replacements){
                text = text.replace("%"+li.get(0)+"%",li.get(1));
            }
        }
        return text;
    }
}