class Solution {
    public double maxPrice(int[][] items, int capacity) {
        
        Arrays.sort(items, (a, b) -> b[0]*a[1] - a[0]*b[1]); 
        // sort array by price per weight unit
        // compare method will return int, so use multiplication instead of b[0]/b[1] division

        double totalWeight = 0, totalPrice = 0;
        int index = 0;

        while(totalWeight <= capacity && index < items.length) {
            int[] item = items[index];
            double price = (double) item[0], weight = (double) item[1];

            if(capacity - totalWeight >= weight) {
                totalWeight += weight;
                totalPrice += price;
            } else {
                double diff = capacity - totalWeight;
                totalWeight += diff;
                totalPrice += diff / weight * price;
            }
            index++;
        }

        if(totalWeight < capacity) return -1;

        return totalPrice;
    }
}