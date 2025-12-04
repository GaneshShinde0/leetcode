class Solution {
    public int countCollisions(String directions) {
        Stack<Character> stk = new Stack<>();
        System.out.println();
        int res = 0;
        for(char c: directions.toCharArray()){
            // if (stk.isEmpty() && c=='R'||c=='S') stk.push(c);
            if (!stk.isEmpty() && stk.peek()=='R' && c=='L') {
                res+=2;
                stk.pop();
                c='S';
            }
            if(c=='S'){
                while(!stk.isEmpty() && stk.peek()=='R'){
                    res+=1;
                    stk.pop();
                }
                stk.push(c);
            }else if(!stk.isEmpty() && stk.peek()=='S' && c=='L'){
                res+=1;
            }else if(c!='L'){
                stk.push(c);
            }
        }
        return res;
    }
}