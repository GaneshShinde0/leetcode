class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a:asteroids){
            if(a>0){
                stack.push(a);
            }else{
                while(!stack.isEmpty()&&stack.peek()>0 && stack.peek()<-a){
                    stack.pop();
                }
                if(stack.isEmpty()||stack.peek()<0){
                    stack.push(a);
                }
                if(stack.peek()==-a) stack.pop();
            }
        }
        int[] res = new int[stack.size()];
        int i = stack.size()-1;
        while(!stack.isEmpty()){
            res[i--]=stack.pop();
        }
        return res;
    }

    public int[] asteroidCollisionDoesNotWork(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        int n = asteroids.length;
        stk.add(asteroids[0]);
        for(int i=1;i<n;i++){
            int top = stk.peek();
            int curr = asteroids[i];
            if((top<0 && curr<0)||(top>0&&curr>0)){
                stk.add(curr);
            }else{
                top = stk.pop();
                if(Math.abs(top)>Math.abs(curr)){
                    stk.add(top);
                }else if(Math.abs(top)<Math.abs(curr)){
                    stk.add(curr);
                }
            }
        }
        System.out.println(stk);
        return new int[]{0};
    }
}