class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        int DMember=0, RMember = 0;
        for(char c:senate.toCharArray()){
            queue.add(c);
            if(c=='D') DMember++;
            else RMember++;
        }
        int dVote = 0, rVote = 0;
        while(DMember!=0 && RMember!=0){
            if(queue.peek()=='R'){
                if(dVote>0){
                    queue.poll();
                    dVote--;
                    RMember--;
                }else{
                    queue.add(queue.poll());
                    rVote++;
                }
            }else{
                if(rVote>0){
                    queue.poll();
                    rVote--;
                    DMember--;
                }else{
                    queue.add(queue.poll());
                    dVote++;
                }
            }
        }
        if(DMember>0) return "Dire";
        else return "Radiant";
    }
}