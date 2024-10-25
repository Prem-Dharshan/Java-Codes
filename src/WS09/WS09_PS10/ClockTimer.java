package WS09.WS09_PS10;

import javafx.application.Platform;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ClockTimer {

    private static final long WAIT_TIME = 500;

    public interface TimerEvent
    {
        public void timeGiven(final SevenSegTime t);
    }

    private class Clock extends Thread {

        private final Object ctrlLock = new Object();
        private volatile boolean cont = true;
        private final Object done = new Object();

        public Clock()
        {
            super("Clock");
        }

        public void end()
        {
            synchronized(ctrlLock)
            {
                if (cont!=false)
                {
                    cont=false;
                } else {
                    return; // already stopped
                }
            }

            try {
                synchronized (done)
                {
                    done.wait();
                }
            } catch (InterruptedException e)
            {
                Logger.log(e);
            }
        }

        public boolean isEnded()
        {
            synchronized (ctrlLock)
            {
                return !cont;
            }
        }

        public void run() {

            do {
                try {
                    Thread.sleep(WAIT_TIME);
                } catch (InterruptedException e)
                {
                    Logger.log(e);
                }

                Platform.runLater(new Runnable() {
                    public void run() {
                        fireTimerEvent(new SevenSegTime(System.currentTimeMillis()));
                    }
                });

            } while (!isEnded());

            Logger.log("Clock finished");

            synchronized (done) {
                done.notify();
            }

        }

    }


    private ArrayList<WeakReference<TimerEvent>> listeners = new ArrayList<WeakReference<TimerEvent>>();
    private final Object listenerLock = new Object();
    private Clock internalClock;


    public void Timer() {
    }

    public void start(final TimerEvent t)
    {
        addTimerEvent(t);
        start();
    }

    public void start()
    {
        if (internalClock!=null)
        {
            if (!internalClock.isEnded())
            {
                internalClock.end();
            }
            internalClock = null;
        }

        internalClock = new Clock();
        internalClock.start();
    }

    public void stop()
    {
        if (internalClock!=null)
        {
            internalClock.end();
        }
    }

    public void addTimerEvent(TimerEvent t)
    {
        synchronized (listenerLock)
        {
            listeners.add(new WeakReference<TimerEvent>( t ));
        }
    }

    protected void fireTimerEvent(final SevenSegTime s)
    {
        assert Platform.isFxApplicationThread() : "need fxapplication thread";
        synchronized( listenerLock )
        {
            for (WeakReference<TimerEvent> t : listeners)
            {
                if (t.get()!=null) {
                    t.get().timeGiven(s);
                }
            }
        }
    }

}