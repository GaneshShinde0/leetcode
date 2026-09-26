class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        int n = s.length(), i = 0;
        HashMap<String, String> hm = new HashMap<>();
        for(List<String> li: knowledge) hm.put(li.get(0), li.get(1));
        while(i<n){
            if(s.charAt(i)=='('){
                i++;
                StringBuilder inner = new StringBuilder();
                while(s.charAt(i)!=')'){
                    inner.append(s.charAt(i));
                    i++;
                }
                sb.append(hm.getOrDefault(inner.toString(),
                "?"));
            }else{
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}