/*
Approach: Sorting and Stack
Intuition:
- We have not given data in correct order, So we will have to sort robots with their initial order.
- Generally when we have left,right which cancel each other we use stack.
    - Example parenthesis matching {()()} =>valid
    - Left Right cancellation  {R L} => {}

- When we encounter a robot moving to the left (L), It might collide with one or more robots moving to the right (R) that are located to the left of the current robot. We need to compare health of the left-moving robot with the health of each right-mmoving robot it collides with, In the order they were encountered.

- This comparison must continue until one of these scenarios happens.
    1. The left moving robot is destroyed.
    2. The right moving robots are destroyed.
    3. Both are destroyed if their health is equal.

A stack is highly effective for managing this sequence of comparisons and updates.

Note: Every time you encoounter a problem where recent elements need to be revisited or managed in reverse order, consider if a stack miht be appropriate. 

We push right-moving robots onto the stack to keep track of any that could potentially collide with a left-moving robot located a higher position. When we encounter a left-moving robot, we simply pop robots off the stack to handle each collision in correct order.

More specifically, when a left-moving robot is encountered, we stat by popping the robot at the top of the stack, which represents the most recent right-moving robot (R). We compare the health of these two robots, and remove one with less health, reduce another by one.


Algorithm:

1. Initialization
    - Determine the number of robots and store it in n.
    - Create an array indices to keep trakc of original indices of the robots.
    - Create a list result to store the health of the surviving robots.
    - Initialize an empty stack to manage right-moving robots.
2. Sort Robots by Position.
    - Sort the indices array based on the position of the robots to ensure they are processed from left to right.
3. Process Each Robot:
    - Iterate through each current_index in the sorted indices array:
        - If the robot is moving to the right;
            - Push current index onto the stack
        - If the robot is moving to the left('L')
            - While the stack is not empty and the current robot's health is greater than 0.
                - Pop the top robot from the stack (this is the most recent right-moving robot)
                - Compare the health of the current left-moving robot and the top right-moving robot.
                    - If the top right-moving robot has more health: 
                        - Decrease its health by 1 and push it back onto the stack.
                        - Set the current left moving robot's health to 0.
                    - If the current left-moving robot has more health
                        - Decrease its health by 1.
                        - Set the top right-moving robot's health to 0.
                    - If both robots have the same health:
                        - Set both robot's health to 0.
4. Collect Surviving Robots:
    - Iterate throguh each robot index from 0 to n-1:
        - If the robot's health is greater than 0:
            - Append the robot's health to the result list.
5. Return the result list, which coontians the health of the surving robots.

Time Complexity : O(nlogn)
Space Complexity : O(n)
*/

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++)indices[i]=i;
        Arrays.sort(indices,(a,b)-> Integer.compare(positions[a], positions[b]));
        System.out.println(Arrays.toString(indices));
        for(int i:indices){
            if(directions.charAt(i)=='R'){
                stk.push(i);
            }else{
                while(!stk.isEmpty() && healths[i]>0){
                    int top = stk.pop();
                    if(healths[top]>healths[i]){ // Its going right it might ccollide
                        healths[top]-=1;
                        healths[i]=0;
                        stk.push(top);
                    }else if(healths[top]<healths[i]){ // Current robot survived its going to left and it wont be cancelled so no need to add in stack.
                        healths[i]-=1;
                        healths[top]=0;
                    }else{
                        healths[i]=0;
                        healths[top]=0;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(healths[i]>0) result.add(healths[i]);
        }
        return result;
    }
    public List<Integer> survivedRobotsHealthsNeedToModify(int[] positions, int[] healths, String directions) {
        int left = 0, n = positions.length, right = n-1;
        int[][] arr = new int[n][3];
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr[i][0]=positions[i];
            arr[i][1]=healths[i];
            arr[i][2]=directions.charAt(i)=='0'?0:1;
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        while(left<n){
            if(directions.charAt(left)=='L') left++;
        }
        right = left+1;
        while(right<n||left<n){
            if(healths[left]==0){
                left++;
                continue;
            }
            if(directions.charAt(left)=='R'&&(right<n && directions.charAt(right)=='L')){
                if(healths[left]<healths[right]){
                    healths[left]=0;
                    healths[right]-=1;
                    left++;
                }else{
                    healths[right]=0;
                    healths[left]-=1;
                    right++;
                }
            }
        }
        return result;
    }
}