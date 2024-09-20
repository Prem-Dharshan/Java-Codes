/*
3. Write a java program to create five threads with different priorities.
Send two threads of highest priority in sleep state. Check the aliveness of the threads and
mark which thread is long listing.
*/

package WS07;

class ThreadPriorityExample {
    public static void main(String[] args) {
        PriorityThread thread1 = new PriorityThread("Thread-1");
        PriorityThread thread2 = new PriorityThread("Thread-2");
        PriorityThread thread3 = new PriorityThread("Thread-3");
        PriorityThread thread4 = new PriorityThread("Thread-4");
        PriorityThread thread5 = new PriorityThread("Thread-5");

        thread1.setPriority(Thread.MIN_PRIORITY);  // Priority 1
        thread2.setPriority(Thread.NORM_PRIORITY); // Priority 5
        thread3.setPriority(Thread.NORM_PRIORITY); // Priority 5
        thread4.setPriority(Thread.MAX_PRIORITY);  // Priority 10
        thread5.setPriority(Thread.MAX_PRIORITY);  // Priority 10

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            Thread.sleep(100);
            thread4.sleep(1000);
            thread5.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
            throw new RuntimeException(e);
        }

        // Check aliveness and mark long-living threads
        while (true) {
            if (thread1.isAlive()) {
                System.out.println(thread1.getName() + " is still alive.");
            }
            if (thread2.isAlive()) {
                System.out.println(thread2.getName() + " is still alive.");
            }
            if (thread3.isAlive()) {
                System.out.println(thread3.getName() + " is still alive.");
            }
            if (thread4.isAlive()) {
                System.out.println(thread4.getName() + " is still alive. (Long listing)");
            }
            if (thread5.isAlive()) {
                System.out.println(thread5.getName() + " is still alive. (Long listing)");
            }

            if (!thread1.isAlive() && !thread2.isAlive() && !thread3.isAlive() && !thread4.isAlive() && !thread5.isAlive()) {
                break;
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
                throw new RuntimeException(e);
            }
        }

        System.out.println("All threads have finished execution.");
    }
}

class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " is running, count: " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread interrupted.", e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " has finished execution.");
    }
}
