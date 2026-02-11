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

    HashMap<String, String> map1;
    HashMap<String, String> memo;
    public String applySubstitutions2(List<List<String>> replacements, String text) {
        map1  = new HashMap<>();
        memo = new HashMap<>();
        for (List<String> r : replacements){
            map1.put(r.get(0), r.get(1));
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
                String key = s.substring(i + 1, j); // [i + 1, j)  -> %a% -> will give only s.charAt(i+1);
                sb.append(dfs(map1.get(key)));
                i = j;// new start without % 
            }
        }
        String res = sb.toString();
        memo.put(s, res);
        return res;
    }

    public String applySubstitutions3(List<List<String>> replacements, String text) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < replacements.size(); i++) {
            map.put(replacements.get(i).get(0), replacements.get(i).get(1));
        }
        while (text.contains("%")) {
            StringBuilder sb = new StringBuilder();
            String[] arr = text.split("%");
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) sb.append(arr[i]);
                else sb.append(map.get(arr[i]));
            }
            text = sb.toString();
        }
        return text;
    }
    
    
    HashMap<String, List<String>> map;     
    public String applySubstitutions(List<List<String>> replacements, String text) {
        this.memo = new HashMap<>();
        this.map = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (List<String> r : replacements) {
            String key = r.get(0);
            memo.put(key, r.get(1)); 
            inDegree.put(key, 0);
        }
        for (String key : memo.keySet()) {
            String val = memo.get(key);
            int i = 0;
            while ((i = val.indexOf('%', i)) != -1) {
                int next = val.indexOf('%', i + 1);
                String depKey = val.substring(i + 1, next);
                map.computeIfAbsent(depKey, k -> new ArrayList<>()).add(key);
                inDegree.put(key, inDegree.get(key) + 1);
                i = next + 1;
            }
        }
        Queue<String> queue = new LinkedList<>();
        for (String key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) queue.offer(key);
        }
        while (!queue.isEmpty()) {
            String curKey = queue.poll();
            memo.put(curKey, resolve(memo.get(curKey)));
            if (map.containsKey(curKey)) {
                for (String nextKey : map.get(curKey)) {
                    inDegree.put(nextKey, inDegree.get(nextKey) - 1);
                    if (inDegree.get(nextKey) == 0) {
                        queue.offer(nextKey);
                    }
                }
            }
        }
        return resolve(text);
    }
    private String resolve(String s) {
        if (s.indexOf('%') == -1) return s;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '%') {
                sb.append(s.charAt(i));
            } else {
                int j = s.indexOf('%', i + 1);
                String key = s.substring(i + 1, j);
                sb.append(memo.get(key));
                i = j;
            }
        }
        return sb.toString();
    }
}