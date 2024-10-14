class Solution {
    // Initial Solution Takes 13ms Beats 89.87 %
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String,Integer> hm = new HashMap<>();
        for(String s:cpdomains){
            String[] split = s.split("\\.");
            // System.out.println(Arrays.toString(split));
            int count = Integer.parseInt(split[0].split(" ")[0]);
            StringBuilder sb = new StringBuilder();
            int j=split.length-1;
            sb.append(split[j]);
            hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+count);
            j--;
            for(;j>0;j--){
                sb.insert(0,'.');
                sb.insert(0,split[j]);
                hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+count);
            }
            sb.insert(0,'.');
            sb.insert(0,split[0].split(" ")[1]);
            hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+count);
        }
        // System.out.println(hm);
        for(Map.Entry<String,Integer> e:hm.entrySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(e.getValue());
            sb.append(" ");
            sb.append(e.getKey());
            res.add(sb.toString());
        }
        return res;
    }

    //6ms
    public List<String> subdomainVisitsFastestSolution(String[] cpdomains) {
        Map<String, Integer> dC = new HashMap<>();
        for(String d : cpdomains) {
            i(dC, d);
        }
        List<String> l = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(String a : dC.keySet()) {
            s.append(dC.get(a));
            s.append(" ");
            s.append(a);
            l.add(s.toString());
            s = new StringBuilder();
        }
        return l;
    }
    private void i(Map<String, Integer> m, String d) {
        int space = d.indexOf(" ");
        Integer v = Integer.parseInt(d.substring(0, space));
        for(int i = d.length() - 1; i >= space; i--) {
            if(d.charAt(i) == ' ' || d.charAt(i) == '.') {
                String s = d.substring(i+1);
                m.put(s, m.getOrDefault(s, 0) + v);
            }
        }
    }
}
