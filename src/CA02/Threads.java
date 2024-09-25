package CA02;

public class Threads {

    public static void main(String[] args) {

        A obj1 = new A();
        B obj2 = new B();

        // Get priority
        System.out.println(obj1.getPriority());
        System.out.println(obj2.getPriority());
        // 1 is the min and 10 is the max

        // Only suggestion of priority not a compulsion
        obj1.setPriority(2);
        System.out.println(obj1.getPriority());

        obj2.setPriority(Thread.MAX_PRIORITY);
        System.out.println(obj2.getPriority());

        A obj3 = new A();
        obj3.setPriority(Thread.MIN_PRIORITY);
        System.out.println(obj3.getPriority());

        B obj4 = new B();
        obj4.setPriority(Thread.NORM_PRIORITY);
        System.out.println(obj4.getPriority());

        // start() by default calls run()
        // Threads does time sharing so that's why the output is mixed.
        obj1.start();
        obj2.start();

    }
}


// Every thread must have a run method
class A extends Thread {
    public void run() {
        for (int i = 0; i < 40; i++) {  // n must be large enough for the scheduler to do time sharing
            System.out.print("A ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.print("B ");
            try {
                Thread.sleep(120);   // Though B has higher priority, it is stalled more than obj1 thread
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}