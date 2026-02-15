class OrderManagementSystem {

    HashMap<Integer, Integer> buy;
    HashMap<Integer, Integer> sell;
    public OrderManagementSystem() {
        this.buy = new HashMap<>();
        this.sell = new HashMap<>();
    }
    
    public void addOrder(int orderId, String orderType, int price) {
        if(orderType.equals("buy")) this.buy.put(orderId, price);
        else this.sell.put(orderId, price);
    }
    
    public void modifyOrder(int orderId, int newPrice) {
        if(buy.containsKey(orderId)) this.buy.put(orderId, newPrice);
        else if(sell.containsKey(orderId)) this.sell.put(orderId, newPrice);
    }
    
    public void cancelOrder(int orderId) {
        if(buy.containsKey(orderId)) this.buy.remove(orderId);
        else if(sell.containsKey(orderId)) this.sell.remove(orderId);
    }
    
    public int[] getOrdersAtPrice(String orderType, int price) {
        if(orderType.equals("buy")){
            return getOrders(this.buy,price);
        }else{
            return getOrders(this.sell,price);
        }
    }

    public int[] getOrders(HashMap<Integer,Integer> hm, int price){
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e: hm.entrySet()){
            if(e.getValue()==price) res.add(e.getKey());
        }
        int[] resArr = new int[res.size()];
        for(int i=0;i<resArr.length;i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}

/**
 * Your OrderManagementSystem object will be instantiated and called as such:
 * OrderManagementSystem obj = new OrderManagementSystem();
 * obj.addOrder(orderId,orderType,price);
 * obj.modifyOrder(orderId,newPrice);
 * obj.cancelOrder(orderId);
 * int[] param_4 = obj.getOrdersAtPrice(orderType,price);
 */