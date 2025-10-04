class MinStackInitial {
    private Stack<Integer> stk;
    private PriorityQueue<Integer> pq;
    public MinStackInitial() {
        stk = new Stack<>();
        pq = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stk.push(val);
        pq.add(val);
    }
    
    public void pop() {
        pq.remove(stk.pop());
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

class MinStack{
    Stack<Integer> s = new Stack<>(), st = new Stack<>();

    public void push(int val){
        s.push(val);
        if(st.isEmpty()||val<=st.peek())st.push(val);
    }
    public void pop(){
        if(s.peek().equals(st.peek()))st.pop();
        s.pop();
    }
    public int top(){
        return s.isEmpty()?-1:s.peek();
    }
    public int getMin(){
        return st.isEmpty()?-1:st.peek();
    }
}

// class MinStack{
//     Stack<Long> s = new Stack<>();
//     long minEle;
//     public void push(int val){
//         if(s.isEmpty()){
//             s.push((long) val);
//             minEle=val;
//         }else if(val<minEle){
//             s.push(2L*val-minEle);
//             minEle = val;
//         }else{
//             s.push((long) val);
//         }
//     }

//     public void pop(){
//         long t = s.pop();
//         if(t<minEle) minEle = 2*minEle-t;
//     }

//     public int top(){
//         long t = s.peek();
//         return t<minEle? (int)minEle:(int)t;
//     }
//     public int getMin(){
//         return (int) minEle;
//     }
// }
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */