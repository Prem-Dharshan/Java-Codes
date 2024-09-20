/*
2. Write a program to create a class MyThread that extends the Thread class.
The constructor of MyThread should call the base class constructor using super.
The run method of MyThread starts after this. Observe that both the main thread and
the created child thread are executed concurrently.
*/

package WS07;

class ThreadExample {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("Child-Thread");
        myThread.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(300);
                System.out.println(Thread.currentThread().getName() + " is running, count: " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException("Main thread interrupted.", e);
            }
        }
    }
}


class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " is running, count: " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread interrupted.", e);
            }
        }
    }
}
