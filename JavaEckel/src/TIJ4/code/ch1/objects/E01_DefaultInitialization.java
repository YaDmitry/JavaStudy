package TIJ4.code.ch1.objects;

/**
 * Created by Dmitry on 03/12/15.
 */

public class E01_DefaultInitialization {
    int i;
    char c;
    public E01_DefaultInitialization() {
        System.out.println("i = " + i);
        System.out.println("c = [" + c + ']');
    }
    public static void main(String[] args) {
        new E01_DefaultInitialization();
    }
} /* Output: i=0 c=[] *///:~

