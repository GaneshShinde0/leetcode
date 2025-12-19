class Solution {
    public int maxSameLengthRuns(String s) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)==s.charAt(i)){
                count++;
            }else{
                hm.put(count, hm.getOrDefault(count,0)+1);
                count = 1;
            }
        }
        hm.put(count, hm.getOrDefault(count,0)+1);
        int res = 0;
        System.out.println(hm);
        for(int i:hm.values()){
            res = Math.max(i,res);
        }
        return res;
    }
}