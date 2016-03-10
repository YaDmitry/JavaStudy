package lec12_threads.work;

/**
 * Created by dmya on 3/10/2016.
 */
public class ThreadExtends extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": ThreadExtends.run");
    }
}
