class BoundedBlockingQueueInitial {
    int capacity;
    Queue<Integer> queue = new LinkedList<>();
    public BoundedBlockingQueueInitial(int capacity) {
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
    
    public synchronized int size() {
        return queue.size();
    }
}

class BoundedBlockingQueue {
    private ReentrantLock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    private int[] queue;
    private int tail = 0;
    private int head = 0;
    private int size = 0;

    public BoundedBlockingQueue(int capacity){
        queue = new int[capacity];
    }

    public void enqueue(int element) throws InterruptedException{
        lock.lock();
        try{
            while(size == queue.length){
                full.await();
            }
            queue[tail++] = element;
            tail%=queue.length;
            size++;
            empty.signal();
        }finally{
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException{
        lock.lock();
        try{
            while(size==0) empty.await();
            int res = queue[head++];
            head %= queue.length;
            size--;
            full.signal();
            return res;
        }finally{
            lock.unlock();
        }
    }

    public int size() throws InterruptedException{
        lock.lock();
        try{
            return this.size;
        }finally{
            lock.unlock();
        }
    }
}