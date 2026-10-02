class Solution {
    public String minimizeError(String[] prices, int target) {
        float res = 0;
        PriorityQueue<Double> diffHeap = new PriorityQueue<>();
        
        for (String s : prices) {
            float f = Float.valueOf(s);
            double low = Math.floor(f);
            double high = Math.ceil(f);
            
            if (low != high)
                diffHeap.offer((high-f)-(f-low));
            
            res += f-low;
            target -= low;
        }
        
        if (target < 0 || target > diffHeap.size())
            return "-1";
        
        while (target-- > 0)
            res += diffHeap.poll();
        
        return String.format("%.3f", res);
    }
}