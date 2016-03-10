package lec12_threads.work;

/**
 * Created by dmya on 3/10/2016.
 */
public class ThreadRun implements CustomRunnable {

    void run() {
        for (int i = 0; i < 10; i++)
            System.out.println("ThreadRun.run: i = " + i);
    }
}
