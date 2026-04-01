class BoundedBlockingQueue {
    int capacity;
    Queue<Integer> queue = new LinkedList<>();
    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }
    
    public synchronized void enqueue(int element) throws InterruptedException {
        while(queue.size()==capacity){
            wait();
        }
        queue.add(element);
        notifyAll();
    }
    
    public synchronized int dequeue() throws InterruptedException {
        while(queue.isEmpty()) wait();
        int value = queue.poll();
        notifyAll();
        return value;
    }
    
    public int size() {
        return queue.size();
    }
}