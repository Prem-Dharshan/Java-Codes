package CA02;

public class Runnables {
    public static void main(String[] args){

        AA obj1 = new AA();
        BB obj2 = new BB();

        // Runnable doesn't have start()
        // obj1.start();

        // To make a Runnable a thread with start, declare a explicit thread
        Thread thread1 = new Thread(obj1);
        Thread thread2 = new Thread(obj2);

        thread1.start();
        thread2.start();

        // Create a Runnable obj directly
        Runnable obj3 = new Runnable() {
            public void run() {
                for(int i = 0; i<10; i++){
                    System.out.println("AA");
                    try{
                        Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread thread3 = new Thread(obj3);
        thread3.start();

        // Lambda Declaration
        Runnable obj4 = () -> {
            for(int i = 0; i<10; i++){
                System.out.println("obj4");
                try {
                    Thread.sleep(10);
                }
                catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread4 = new Thread(obj4);
        thread4.start();

        return;
    }
}

class AA implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            System.out.println("AA");
            try{
                Thread.sleep(10);
            }
            catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}

class BB implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            System.out.println("BB");
            try{
                Thread.sleep(10);
            }
            catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}