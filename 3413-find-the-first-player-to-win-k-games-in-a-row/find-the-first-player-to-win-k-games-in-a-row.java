/*
skills = [11,9,12,2,20,1,8], k = 3
k = 0
*/
class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        HashMap<Integer,Integer> streak = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int max = 0;
        for(int i=0;i<skills.length;i++){
            hm.put(skills[i],i);
            queue.add(skills[i]);
            max = Math.max(skills[i], max);
        }
        while(streak.getOrDefault(queue.peekFirst(),0)<Math.min(k,skills.length)){
            int t1 = queue.pollFirst();
            int t2 = queue.pollFirst();
            if(t1>t2){
                streak.put(t1,streak.getOrDefault(t1,0)+1);
                streak.put(t2,0);
                queue.addFirst(t1);
                queue.addLast(t2);
            }else{
                streak.put(t2,streak.getOrDefault(t2,0)+1);
                streak.put(t1,0);
                queue.addFirst(t2);
                queue.addLast(t1);
            }
        }
        return hm.get(queue.peekFirst());
    }
}