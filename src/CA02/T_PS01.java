package CA02;

public class T_PS01 {

    public static void main(String[] args) throws InterruptedException {

        Runnable r1 = new RunnableDemo();
        Runnable r2 = new RunnableDemo();
        Runnable r3 = new RunnableDemo();
        Runnable r4 = new RunnableDemo();

        Thread t1 = new Thread(r1, "T1");
        Thread t2 = new Thread(r2, "T2");
        Thread t3 = new Thread(r3, "T3");
        Thread t4 = new Thread(r4, "T4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("T4 paavam");

        return;
    }
}

class RunnableDemo implements Runnable {
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is running.");
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " has finished running.");
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }
    }
}