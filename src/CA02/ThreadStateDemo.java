package CA02;

class ThreadStateDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new CustomRunnable());

        // Thread is in NEW state before start() is called
        System.out.println("State after thread creation: " + thread.getState()); // NEW

        thread.start();

        // Thread is in RUNNABLE state after calling start()
        System.out.println("State after calling start(): " + thread.getState()); // RUNNABLE

        // Sleep to allow thread to start execution
        Thread.sleep(100);

        // Check the state while the thread is running (likely still RUNNABLE)
        System.out.println("State during execution: " + thread.getState());

        synchronized (ThreadStateDemo.class) {
            // Wake the thread from TIMED_WAITING
            ThreadStateDemo.class.notify();
        }

        // Wait for the thread to finish
        thread.join();

        // Thread is in TERMINATED state after execution is complete
        System.out.println("State after completion: " + thread.getState()); // TERMINATED
    }
}

class CustomRunnable implements Runnable {

    @Override
    public void run() {
        try {
            // Thread is in TIMED_WAITING state
            Thread.sleep(500);
            System.out.println("State during sleep (TIMED_WAITING)");

            synchronized (ThreadStateDemo.class) {
                // Thread goes into WAITING state
                ThreadStateDemo.class.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Now thread will finish its execution (TERMINATED state later)
        System.out.println("Thread is finishing execution");
    }
}
