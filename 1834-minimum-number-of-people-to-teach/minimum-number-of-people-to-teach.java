class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> cannotCommunicate = new HashSet<>();
        for(int[] friendship : friendships){
            Map<Integer,Integer> hm = new HashMap<>();
            boolean comm = false;
            for(int lan:languages[friendship[0]-1]){
                hm.put(lan,1);
            }
            for(int lan:languages[friendship[1]-1]){
                if(hm.containsKey(lan)){
                    comm = true;
                    break;
                }
            }
            if(!comm){
                cannotCommunicate.add(friendship[0]-1);
                cannotCommunicate.add(friendship[1]-1);
            }
        }
        int max_cnt = 0;
        int[] cnt = new int[n+1];
        for(int friendship:cannotCommunicate){
            for(int lan:languages[friendship]){
                cnt[lan]++;
                max_cnt = Math.max(max_cnt, cnt[lan]);
            }
        }
        return cannotCommunicate.size()-max_cnt;
    }
}