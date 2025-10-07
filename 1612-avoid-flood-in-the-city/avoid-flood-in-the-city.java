class Solution {
    public int[] avoidFloodInitial(int[] rains) {
        int n =rains.length;
        int[] res = new int[n];
        int fullLakes = 0;
        // Map<Integer, Integer> lakeToFloodCount = new HashMap<>();
        // Queue<Integer> q = new LinkedList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            if(rains[i]>0){
                if(set.contains(rains[i])) return new int[]{};
                fullLakes++;
                res[i]=-1;
                set.add(rains[i]);
            }else{
                if(set.size()>0){
                    res[i]=set.pollFirst();
                }else{
                    res[i]=1;
                }
            }
        }
        return res;
    }

    public int[] avoidFlood(int[] rains){
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);// 
        TreeSet<Integer> st = new TreeSet<>();
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(rains[i]==0){
                st.add(i);
            }else{
                ans[i]=-1;
                if(hm.containsKey(rains[i])){
                    Integer it = st.ceiling(hm.get(rains[i]));
                    if(it ==null){
                        return new int[0];
                    }
                    ans[it]=rains[i];
                    st.remove(it);
                }
                hm.put(rains[i],i);
            }
        }
        return ans;
    }
}