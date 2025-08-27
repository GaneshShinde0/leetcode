class FooBar {
    private int n;
    private volatile int counter;

    public FooBar(int n) {
        this.n = n;
        counter = 0;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(counter%2!=0){}
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            counter++;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(counter%2==0){};
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            counter++;
        }
    }
}