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
class OrderManagementSystem2 {
    // Current price of each order: orderId -> price
    Map<Integer, Integer> buyOrders = new HashMap<>();
    Map<Integer, Integer> sellOrders = new HashMap<>();

    // Quick lookup: price -> Set of orderIds
    Map<Integer, Set<Integer>> buyPriceMap = new HashMap<>();
    Map<Integer, Set<Integer>> sellPriceMap = new HashMap<>();

    public OrderManagementSystem2() {}

    public void addOrder(int orderId, String orderType, int price) {
        if (orderType.equals("buy")) {
            buyOrders.put(orderId, price);
            buyPriceMap.computeIfAbsent(price, k -> new HashSet<>()).add(orderId);
        } else {
            sellOrders.put(orderId, price);
            sellPriceMap.computeIfAbsent(price, k -> new HashSet<>()).add(orderId);
        }
    }

    public void modifyOrder(int orderId, int newPrice) {
        if (buyOrders.containsKey(orderId)) {
            int oldPrice = buyOrders.get(orderId);
            buyPriceMap.get(oldPrice).remove(orderId);
            buyOrders.put(orderId, newPrice);
            buyPriceMap.computeIfAbsent(newPrice, k -> new HashSet<>()).add(orderId);
        } else if (sellOrders.containsKey(orderId)) {
            int oldPrice = sellOrders.get(orderId);
            sellPriceMap.get(oldPrice).remove(orderId);
            sellOrders.put(orderId, newPrice);
            sellPriceMap.computeIfAbsent(newPrice, k -> new HashSet<>()).add(orderId);
        }
    }

    public void cancelOrder(int orderId) {
        if (buyOrders.containsKey(orderId)) {
            int price = buyOrders.remove(orderId);
            buyPriceMap.get(price).remove(orderId);
        } else if (sellOrders.containsKey(orderId)) {
            int price = sellOrders.remove(orderId);
            sellPriceMap.get(price).remove(orderId);
        }
    }

    public int[] getOrdersAtPrice(String orderType, int price) {
        Map<Integer, Set<Integer>> targetMap = orderType.equals("buy") ? buyPriceMap : sellPriceMap;
        Set<Integer> set = targetMap.get(price);
        
        if (set == null || set.isEmpty()) return new int[0];
        
        int[] res = new int[set.size()];
        int i = 0;
        for (int id : set) res[i++] = id;
        return res;
    }
}
class OrderManagementSystem {
    // Maps orderId -> price
    Map<Integer, Integer> buyOrders = new HashMap<>();
    Map<Integer, Integer> sellOrders = new HashMap<>();

    // Maps price -> Set of orderIds (This makes lookup O(1) instead of O(N))
    Map<Integer, Set<Integer>> buyPriceMap = new HashMap<>();
    Map<Integer, Set<Integer>> sellPriceMap = new HashMap<>();

    public void addOrder(int orderId, String orderType, int price) {
        if (orderType.equals("buy")) {
            buyOrders.put(orderId, price);
            buyPriceMap.computeIfAbsent(price, k -> new HashSet<>()).add(orderId);
        } else {
            sellOrders.put(orderId, price);
            sellPriceMap.computeIfAbsent(price, k -> new HashSet<>()).add(orderId);
        }
    }

    public void modifyOrder(int orderId, int newPrice) {
        if (buyOrders.containsKey(orderId)) {
            int oldPrice = buyOrders.get(orderId);
            buyPriceMap.get(oldPrice).remove(orderId);
            addOrder(orderId, "buy", newPrice);
        } else if (sellOrders.containsKey(orderId)) {
            int oldPrice = sellOrders.get(orderId);
            sellPriceMap.get(oldPrice).remove(orderId);
            addOrder(orderId, "sell", newPrice);
        }
    }

    public void cancelOrder(int orderId) {
        if (buyOrders.containsKey(orderId)) {
            int price = buyOrders.remove(orderId);
            buyPriceMap.get(price).remove(orderId);
        } else if (sellOrders.containsKey(orderId)) {
            int price = sellOrders.remove(orderId);
            sellPriceMap.get(price).remove(orderId);
        }
    }

    public int[] getOrdersAtPrice(String orderType, int price) {
        Set<Integer> ids = (orderType.equals("buy") ? buyPriceMap : sellPriceMap).get(price);
        if (ids == null || ids.isEmpty()) return new int[0];
        
        int[] res = new int[ids.size()];
        int i = 0;
        for (int id : ids) res[i++] = id;
        return res;
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