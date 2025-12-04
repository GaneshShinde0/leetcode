class Solution {
    public int countCollisionsInitial(String directions) {
        Stack<Character> stk = new Stack<>();
        // System.out.println();
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

    
    public int countCollisions(String directions) {
        int res = 0;
        int flag = -1;
        for (char c : directions.toCharArray()) {
            if (c == 'L') {
                if (flag >= 0) {
                    res += flag + 1;
                    flag = 0;
                }
            } else if (c == 'S') {
                if (flag > 0) {
                    res += flag;
                }
                flag = 0;
            } else {
                if (flag >= 0) {
                    flag++;
                } else {
                    flag = 1;
                }
            }
        }
        return res;
    }
}