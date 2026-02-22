class MyCircularQueue {
    class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    int size;
    Node head;
    Node tail;
    int curr;
    public MyCircularQueue(int k) {
        this.size = k;
        this.curr = 0;
        this.head = this.tail = null;
    }
    
    public boolean enQueue(int value) {
        if(curr==size) return false;
        Node node = new Node(value);
        if(head==null && tail==null){
            head = node;
            tail = node;
        }
        tail.next = node;
        tail = node;
        tail.next = head;
        curr++;
        return true;
    }
    
    public boolean deQueue() {
        if(curr==0) return false;
        if(curr==1){
            head=null;
            tail=null;
            curr--;
            return true;
        }
        Node temp = head.next;
        tail.next = temp;
        head = temp;
        curr--;
        return true;
    }
    
    public int Front() {
        if(head==null) return -1;
        return head.val;
    }
    
    public int Rear() {
        if(tail==null) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return curr==0;
    }
    
    public boolean isFull() {
        return curr==size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */