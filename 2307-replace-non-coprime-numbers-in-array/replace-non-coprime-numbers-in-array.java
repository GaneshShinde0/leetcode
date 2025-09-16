class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        for(int num:nums){
            while(!stk.isEmpty()){
                int temp = stk.peek();
                int x = gcd(temp,num);
                if(x==1) break; // This makes sure elements are co-primes;
                num *= temp/x;
                stk.pop();
            }
            stk.add(num);
        }
        List<Integer> result = new ArrayList<>();
        while(!stk.isEmpty()){
            result.add(stk.pop());
        }
        Collections.reverse(result);
        return result;
    }

    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}