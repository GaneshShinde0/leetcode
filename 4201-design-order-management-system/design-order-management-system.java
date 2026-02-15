class OrderManagementSystemInitial{

    HashMap<Integer, Integer> buy;
    HashMap<Integer, Integer> sell;
    public OrderManagementSystemInitial() {
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
class OrderManagementSystem {
    // Stores metadata: orderId -> Order(type, price)
    Map<Integer, Order> orders;
    // Stores lookup: type -> price -> Set of orderIds
    Map<String, Map<Integer, Set<Integer>>> priceMap;

    class Order {
        String type;
        int price;
        Order(String type, int price) {
            this.type = type;
            this.price = price;
        }
    }

    public OrderManagementSystem() {
        orders = new HashMap<>();
        priceMap = new HashMap<>();
        priceMap.put("buy", new HashMap<>());
        priceMap.put("sell", new HashMap<>());
    }
    
    public void addOrder(int orderId, String orderType, int price) {
        orders.put(orderId, new Order(orderType, price));
        priceMap.get(orderType)
                .computeIfAbsent(price, k -> new HashSet<>())
                .add(orderId);
    }
    
    public void modifyOrder(int orderId, int newPrice) {
        if (!orders.containsKey(orderId)) return;
        
        Order order = orders.get(orderId);
        // 1. Remove from the old price set
        priceMap.get(order.type).get(order.price).remove(orderId);
        
        // 2. Update price and add to the new price set
        order.price = newPrice;
        priceMap.get(order.type)
                .computeIfAbsent(newPrice, k -> new HashSet<>())
                .add(orderId);
    }
    
    public void cancelOrder(int orderId) {
        if (!orders.containsKey(orderId)) return;
        
        Order order = orders.remove(orderId);
        priceMap.get(order.type).get(order.price).remove(orderId);
    }
    
    public int[] getOrdersAtPrice(String orderType, int price) {
        Set<Integer> orderIds = priceMap.get(orderType).get(price);
        if (orderIds == null || orderIds.isEmpty()) return new int[0];
        
        return orderIds.stream().mapToInt(Integer::intValue).toArray();
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