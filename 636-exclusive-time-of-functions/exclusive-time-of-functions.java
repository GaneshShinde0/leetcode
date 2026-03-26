/*

n = 2
logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]


Time:|0|1|2|3|4|5|6|
f(0):|0|1|      |5|6| =>3
f(1):    |2|3|4|5|    =>4


main(){
    ....
    f(0)
    ....
}
f(0){
    ....
    f(1)
    ....
}
f(1){
    ....
}

So we basically have to find how much time it took in each function.


If we get start we will push to stack
If we get end we will pop fromm stack 
    Take delta of above two.

*/
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        int prevStartTime = 0;
        for(String log:logs){
            String[] logArr= log.split(":");
            int funcId = Integer.parseInt(logArr[0]);
            String callType = logArr[1];
            int time = Integer.parseInt(logArr[2]);
            if(callType.equals("start")){
                if(!stk.isEmpty()){
                    res[stk.peek()]+=(time-prevStartTime);                    
                }
                stk.add(funcId);
                prevStartTime = time;
            }else{
                res[stk.pop()]+=(time-prevStartTime)+1;// Endpoint is inclusive
                prevStartTime = time+1;
            }
        }
        return res;
    }
}