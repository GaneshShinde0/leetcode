class Solution {
    public String applySubstitutionsInitial(List<List<String>> replacements, String text) {
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

    HashMap<String, String> map;
    HashMap<String, String> memo;
    public String applySubstitutions(List<List<String>> replacements, String text) {
        map  = new HashMap<>();
        memo = new HashMap<>();
        for (List<String> r : replacements){
            map.put(r.get(0), r.get(1));
        }
        return dfs(text);
    }
    private String dfs(String s){
        if (memo.containsKey(s)) return memo.get(s);
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++){
            if (s.charAt(i) != '%') sb.append(s.charAt(i));
            else {
                int j = i + 1;
                while (j < n && s.charAt(j) != '%') j++;
                String key = s.substring(i + 1, j); // [i + 1, j)  -> %a%
                sb.append(dfs(map.get(key)));
                i = j;// new start without % 
            }
        }
        String res = sb.toString();
        memo.put(s, res);
        return res;
    }
}