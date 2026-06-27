class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        int res = 1;
        for(Map.Entry<Integer,Integer> e:freq.entrySet()){
            int key = e.getKey(), value = e.getValue();
            if(key == 1){
                if(value%2==1) res = Math.max(value,res);
                else res = Math.max(value-1,res);
                continue;
            }
            int local=0;
            while(freq.containsKey(key) && freq.get(key)>=2){
                key = key*key;
                local+=2;
            }
            if(freq.containsKey(key)){
                res = Math.max(res, local+1);
            }else{
                res = Math.max(res, local-1);
            }
        }
        return res;
    }
}