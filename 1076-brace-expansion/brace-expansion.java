class Solution {
    public String[] expand(String s) {
        List<StringBuilder> result = new ArrayList<>();
        int i = 0, n = s.length();
        StringBuilder temp = new StringBuilder();
        int start = s.indexOf('{',i);
        result.add(new StringBuilder());
        while(i<n){
            while(i<n && s.charAt(i)!='{'){
                for(StringBuilder sb:result){
                    sb.append(s.charAt(i));
                }
                i++;
            }
            start = s.indexOf('{',i);
            int end = s.indexOf('}',i);
            if(start==-1) break;
            String[] mid = s.substring(start+1,end).split(",");
            List<StringBuilder> curr = new ArrayList();
            for(StringBuilder sb:result){
                for(String m:mid){
                    StringBuilder sub = new StringBuilder(sb);
                    sub.append(m);
                    curr.add(sub);
                }
            }
            result = curr;
            i=Math.max(i,end+1);
        }
        String[] res = new String[result.size()];
        for(i=0;i<res.length;i++){
            res[i]=result.get(i).toString();
        }
        Arrays.sort(res);
        return res;
    }
}