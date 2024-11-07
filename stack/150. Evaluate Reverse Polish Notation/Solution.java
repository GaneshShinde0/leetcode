class Solution {
    public int evalRPNInitialSolution(String[] tokens) {
        Stack<String> stk = new Stack();
        int curr=0;
        int res = 0;
        while(curr<tokens.length){
            int idx = "*/+-".indexOf(tokens[curr]);
            int op1 = 0;
            int op2 = 0;
            if(idx>=0){
                op2=Integer.parseInt(stk.pop());
                op1=Integer.parseInt(stk.pop());
                
                if(idx==0){
                    res = op1*op2;
                }else if(idx==1){
                    res = op1/op2;
                }else if(idx==2){
                    res = op1+op2;
                }else if(idx==3){
                    res= op1-op2;
                }
                stk.push(String.valueOf(res));
            }else{
                stk.push(tokens[curr]);
            }
            curr++;
        }
        return Integer.parseInt(stk.pop());
    }

    public int evalRPN(String[] tokens) {
        int[] arr = new int[tokens.length];
        int index = 0;
        for(String token: tokens) {
            switch(token) {
                case "+":
                    arr[index - 2] = arr[index - 2] + arr[index - 1];
                    index--;
                    break;
                case "-":
                    arr[index - 2] = arr[index - 2] - arr[index - 1];
                    index--;
                    break;
                case "*":
                    arr[index - 2] = arr[index - 2] * arr[index - 1];
                    index--;
                    break;
                case "/":
                    arr[index - 2] = arr[index - 2] / arr[index - 1];
                    index--;
                    break;
                default:
                    arr[index++] = Integer.parseInt(token);
                    break;
            }
        }
        return arr[0];
    }
}
