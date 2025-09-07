class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();
        int DMember = 0;
        int RMember = 0;
        for(int i=0; i<senate.length(); i++){
            char c = senate.charAt(i);
            q.add(c);
            if(c=='D') DMember++;
            else RMember++;
        }
        int DVote = 0, RVote = 0;
        while(DMember!=0 && RMember!=0){
            if(q.peek()=='D'){
                if(RVote>0){
                    q.poll();
                    RVote--;
                    DMember--;
                }else{
                    q.add(q.poll());
                    DVote++;
                }
            }else{
                if(DVote>0){
                    q.poll();
                    DVote--;
                    RMember--;
                }else{
                    q.add(q.poll());
                    RVote++;
                }
            }
        }

        if(DMember>0) return "Dire";
        else return "Radiant";
    }
}