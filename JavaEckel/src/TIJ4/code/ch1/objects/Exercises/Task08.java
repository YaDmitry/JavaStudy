package TIJ4.code.ch1.objects.Exercises;

public class Task08 {
    static int i;
    int i2;

    /*
    независимо от того, сколько
        объектов вы создаете

    есть только один экземпляр конкретного
        статического поля в этом классе.
     */
    static Task08 t1 = new Task08();
    static Task08 t2 = new Task08();
    static Task08 t3 = new Task08();

    public static void main(String[] args) {
        printAll();

        i++;
        System.out.println("i++");

        printAll();
    }

    public static void printAll() {
        System.out.println("t1.i = " + t1.i);
        System.out.println("t2.i = " + t2.i);
        System.out.println("t3.i = " + t3.i);
        System.out.println("t1.i = " + t1.i2);
        System.out.println("t2.i = " + t2.i2);
        System.out.println("t3.i = " + t3.i2);
        System.out.println("Task08.i = " + Task08.i);
        System.out.println("Task08.i2 = none");
    }
}