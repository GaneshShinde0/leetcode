class Solution {
    public int[] dailyTemperaturesFails1TestCase(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length-1;i++){
            for(int j=i+1;j<temperatures.length;j++){
                if (temperatures[j]>temperatures[i]){
                    res[i]=j-i;
                    break;
                }
            }
        }
        return res;
    }
    // Using Stack
    // Takes 77 ms
    public int[] dailyTemperatures77ms(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!stk.isEmpty()&&temperatures[stk.peek()]<temperatures[i]){
                res[stk.peek()]=i-stk.pop();
            }
            stk.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int hot = 0;
        int[] ans  = new int[temperatures.length];
        for(int i = temperatures.length-1; i >=0; i--){
            int t = temperatures[i];
            if(t >= hot){
                hot = t;
                continue;
            }
            int days = 1;
            while(t >= temperatures[days+i]){
                days += ans[days+i];
            }
            ans[i] = days;
        }

        return ans;
        
    }
}
