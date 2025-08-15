class StockSpannerNaive {
    List<Integer> li;
    int i;
    public StockSpannerNaive() {
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


class Node{
    int price;
    int span;
    Node next;
    Node(int price, int span){
        this.price = price;
        this.span = span;
        this.next = null;
    }
}
class StockSpanner {
    Node top;
    public StockSpanner() {
        top = null;
    }
    
    public int next(int price) {
        Node node;
        int span = 1;
        while(top!=null&&top.price<=price){
            span+=top.span;
            top=top.next;
        }
        node = new Node(price,span);
        node.next = top;
        top = node;
        return top.span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */