class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> cannotCommunicate = new HashSet<>();
        for(int[] friendship:friendships){
            boolean areCommunicating = false;
            Set<Integer> langKnown = new HashSet<>();
            for(int i:languages[friendship[0]-1]){
                langKnown.add(i);
            }
            for(int j:languages[friendship[1]-1]){
                if(langKnown.contains(j)){
                    areCommunicating = true;
                    break;
                }
            }
            if(!areCommunicating){
                cannotCommunicate.add(friendship[0]-1);
                cannotCommunicate.add(friendship[1]-1);
            }
        }
        int maxLangKnown = 0;
        int[] langCount = new int[n+1];
        for(int i: cannotCommunicate){
            for(int j:languages[i]){
                langCount[j]++;
                maxLangKnown = Math.max(maxLangKnown,langCount[j]);
            }
        }
        return cannotCommunicate.size()-maxLangKnown;
    }
}


        // Map<Integer,Integer> hm = new HashMap<>();
        // for(int[] lang:languages){
        //     for(int i:lang){
        //         hm.put(i,hm.getOrDefault(i,0)+1);
        //     }
        // }
        // int res =languages[0][0];
        // for(Map.Entry<Integer,Integer> e: hm.entrySet()){
        //     if(e.getValue()>hm.get(res)){
        //         res = e.getKey();
        //     }
        // }

        // return res;