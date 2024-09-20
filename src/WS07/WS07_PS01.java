/*
1. Write a program to illustrate creation of threads using Runnable interface.
Each thread should be started and inside the run method, it should sleep for 500 milliseconds.
*/

package WS07;


class ThreadDemo {
    public static void main(String[] args) {
        Runnable runnable1 = new MyRunnable();
        Runnable runnable2 = new MyRunnable();
        Runnable runnable3 = new MyRunnable();

        Thread thread1 = new Thread(runnable1, "Thread-1");
        Thread thread2 = new Thread(runnable2, "Thread-2");
        Thread thread3 = new Thread(runnable3, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("All threads have finished execution.");
    }
}

class MyRunnable implements Runnable {
    @Override
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