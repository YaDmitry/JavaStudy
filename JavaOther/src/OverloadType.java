/**
 * Created by Dmitry on 25/11/15.
 */
public class OverloadType {

    static int add (int a, int b) {
        return a + b;
    }

    //Overload method with diff return type; works only with diff arguments in the method
    static String add(int a, int b, int c){
        return "Overload method returned a String";
    }

    public static void main(String[] args) {

        System.out.println(add(12, 13));
        System.out.println(add(12, 13, 14));

    }

}
