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
        Stack<Character> stack = new Stack<>();
        int collisions = 0;

        for (char c : directions.toCharArray()) {

            // Case 1: R → L collision
            if (!stack.isEmpty() && stack.peek() == 'R' && c == 'L') {
                collisions += 2;
                stack.pop();
                c = 'S';     // becomes stationary after collision
            }

            // Case 2: anything hits a stationary car
            if (c == 'S') {
                // All previous R cars will collide into S
                while (!stack.isEmpty() && stack.peek() == 'R') {
                    collisions++;
                    stack.pop();
                }
                stack.push('S');
                continue;
            }

            // Case 3: L car hits stationary S
            if (!stack.isEmpty() && stack.peek() == 'S' && c == 'L') {
                collisions++;
                continue;   // L disappears, no push
            }

            // Case 4: Safe push (R or L when no collision)
            stack.push(c);
        }

        return collisions;
    }

    
    public int countCollisionsSecond(String directions) {
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
    public int countCollisions100(String str) {
        int count=0;
        int left=0,right=str.length()-1;
        char[] s=str.toCharArray();
        while(left<s.length && s[left]=='L'){
            left++;
        }
        while(right>=0 && s[right]=='R'){
            right--;
        }
        for(int i=left;i<=right;i++){
            if(s[i]!='S') count++;
        }
        return count;
    }
}