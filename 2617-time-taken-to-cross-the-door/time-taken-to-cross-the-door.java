class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int[] ans = new int[state.length];

        // Separating the enter and exit people helps coz each enter and exit is a 1 sec operation, so, say, if multiple people are in line for enter/exit at same second, then the enter/exit operations will cause those people to wait, and any future people coming for enter/exit will need to be combined with these waiting people for future operations. Separating helps coz the queue's latest element (poll()) already contains those future enter/exit people.
        Queue<Integer> enterQ = new LinkedList<>();
        Queue<Integer> exitQ = new LinkedList<>();

        int time=0; // Global counter for time, we start at t=0;
        int prevSecState = 1; // a toggle variable, 0 means someone entered the prev second, and 1 means exit at prev sec. Now in case no enter or exit done in prev sec, we default it to 1, as in that case we need to give exit a priority.

        for(int i=0; i<state.length;i++){
            if(state[i]==0){
                enterQ.add(i);
            } else {
                exitQ.add(i);
            }
        }
        while(!enterQ.isEmpty() && !exitQ.isEmpty()){
            // if people are in queue for both entering and exiting
            if (arrival[enterQ.peek()]<=time && arrival[exitQ.peek()]<=time){
                // if a person entered in last sec, then enter is prioritised
                if(prevSecState == 0){
                    int index = enterQ.poll();
                    ans[index] = time;
                } else { // else exit is prioritised
                    int index = exitQ.poll();
                    ans[index] = time;
                }
            } else if(arrival[enterQ.peek()]<=time && arrival[exitQ.peek()]>time) {
            // if people are in queue for entering, at this second.
            // We dont need to check for prev second state here, as at this second only one type of people exist at door(enter people)
                ans[enterQ.poll()] = time;
                // update/toggle the prevsecond variable
                prevSecState = 0;
            } else if(arrival[enterQ.peek()]>time && arrival[exitQ.peek()]<=time) {
            // if people are in queue for exiting, at this second.
            // We dont need to check for prev second state here, as at this second only one type of people exist at door(exit people)
                ans[exitQ.poll()] = time;
                // update/toggle the prevsecond variable
                prevSecState = 1;
            } else { // no one present at this second to enter or exit the door.
                // make prevsecstate to default state, to prioritise exits(default state)
                prevSecState = 1;
            }
            // time ticks regardless of condition, as time waits for no one :)
            time++;
        }

        while(!enterQ.isEmpty()){
            // We dont need to worry about prevSecState  anymore at this point, coz only enter people remain, so no need to add prioritising logic(it doesnt make sense)
            int index = enterQ.poll();
            time = Math.max(time, arrival[index]); // no one there in the previous seconds to enter or exit, so we take max.
            ans[index] = time;
            time++; // time waits for none :)
        }

        while(!exitQ.isEmpty()){
            // We dont need to worry about prevSecState  anymore at this point, coz only exit people remain, so no need to add prioritising logic(it doesnt make sense)
            int index = exitQ.poll();
            time = Math.max(time, arrival[index]); // same logic as above
            ans[index] = time;
            time++; // u know why :)
        }

        return ans;
    }
}