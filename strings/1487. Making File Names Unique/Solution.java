class Solution {
    public String[] getFolderNamesTLE(String[] names) {
        Set<String> hs = new HashSet<>();
        String[] res = new String[names.length];
        int i=0;
        for(String name:names){
            int count=0;
            String temp = name;
            while(hs.contains(name)){
                count++;
                StringBuilder sb = new StringBuilder(temp);
                sb.append("(").append(count).append(")");
                name = sb.toString();
            }
            hs.add(name);
            res[i]=name;
            i++;
        }
        return res;
    }

    public String[] getFolderNames(String[] names) {
        Map<String,Integer> hm = new HashMap<>();
        String[] res = new String[names.length];
        int i=0;
        for(String name:names){
            String temp = new String(name);
            if(hm.containsKey(name)){
                int count=hm.get(name);
                while(hm.containsKey(name)){
                    count++;
                    StringBuilder sb = new StringBuilder(temp);
                    sb.append("(").append(count).append(")");
                    name = sb.toString();
                }
                hm.put(temp,count);
            }
            hm.put(name,0);
            res[i]=name;
            i++;
        }
        return res;
    }
}
