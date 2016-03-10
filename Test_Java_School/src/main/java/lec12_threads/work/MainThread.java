package lec12_threads.work;

/**
 * Created by dmya on 3/10/2016.
 */
public class MainThread {

    public static void main(String[] args) {
//        ThreadExtends threadExtends = new ThreadExtends();
//        threadExtends.start();
//        System.out.println(Thread.currentThread().getName() + ": end of main");
//        threadExtends.run();

        ThreadRun threadRun = new ThreadRun();
//        Thread thread = new Thread(threadRun);
//        thread.start();

        for (int i = 0; i < 10; i++)
            System.out.println("main: i = " + i);

    }
}
