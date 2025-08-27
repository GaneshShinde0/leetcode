class Foo {

    public static volatile int counter;
    public Foo() {
        counter=0;
    }

    public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            counter = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(counter!=1);     
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            counter = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(counter!=2);
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            counter = 3;
    }
}