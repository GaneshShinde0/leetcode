class StockSpanner {
    List<Integer> li;
    int i;
    public StockSpanner() {
        li = new ArrayList<>();
        i=0;
    }
    
    public int next(int price) {
        li.add(price);
        int res = 0;
        for(int i=li.size()-1;i>=0;i--){
            if(li.get(i)<=price){
                res++;
            }else break;
        }
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */