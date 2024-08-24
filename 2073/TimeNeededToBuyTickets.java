class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res =0;
        for(int i=0;i<tickets.length;i++){
            // Those who come before K, for them we should add all tickets until tickets[k]
            if(i<=k){
                res+=Math.min(tickets[k],tickets[i]);
            }
            // Those who come after K, for them they will receive 1 ticket less than that of K. (Because previous guys will take one more ticket than k and after guys will take one less ticket than K (Everyone is supposed to buy one ticket at a time))
            else{
                res+=Math.min(tickets[k]-1,tickets[i]);
            }
        }
        return res;
    }
}
