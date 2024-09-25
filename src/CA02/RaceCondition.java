package CA02;

// Thread safe = only one thread can work with a data at a time
public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable obj1 = () -> {
            for (int i = 0; i < 10000; i++){
//                System.out.print("obj1 ");
                counter.increment();
                counter.syncInc();
            }
        };

        Runnable obj2 = () -> {
            for (int i = 0; i < 1000; i++){
//                System.out.print("obj2 ");
                counter.increment();
                counter.syncInc();
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        // Results in 0, coz we think it runs after thread is completed
        // But main() simply starts/initiates the threads and just moves to the next line of code
        // Therefore, we get 0 before threads increment the counter
        System.out.println("Counter: " + counter.count);

        // This says main thread to join and wait for the t1 and t2
        t1.join();
        t2.join();

        System.out.println("Counter: " + counter.count);

        // But what if t1 and t2 tries to increment at the same time for the shared var counter?
        // Therefore, to avoid collision of threads, we use synchronized

        System.out.println("Synchronized Counter: " + counter.synCount);


        return;
    }
}


class Counter {
    int count = 0;
    int synCount = 0;

    public void increment(){
        count++;
    }

    public synchronized void syncInc(){
        synCount++;
    }
}