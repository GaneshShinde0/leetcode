class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int task:tasks){
            hm.put(task,hm.getOrDefault(task,0)+1);
        }
        int res = 0;
        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            int freq = e.getValue();
            if(e.getValue()==1) return -1;
            int threes = e.getValue()/3;
            int remainder = e.getValue()%3;
            if(remainder==1||remainder==2){
                threes+=1;
            }
            res+=threes;
        }
        return res;
    }
}