
import java.util.concurrent.Exchanger;

public class Foo{
    private final Exchanger<Boolean> exchanger12 = new Exchanger<>();
    private final Exchanger<Boolean> exchanger23 = new Exchanger<>();

    public Foo(){

    }

    public void first(Runnable printFirst) throws InterruptedException{
        printFirst.run();
        try{
            exchanger12.exchange(true); // Singal that first() has completed.
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException{
        try{
            exchanger12.exchange(true); // Wait for first() to complete
            printSecond.run();
            exchanger23.exchange(true); // Signal that second() has completed.
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void third(Runnable printThird) throws InterruptedException{
        try{
            exchanger23.exchange(true); // Wait for second() to complete
            printThird.run();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

// Using volatile
/*

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

*/