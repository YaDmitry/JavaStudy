package lec14_junit.work;

/**
 * Created by dmya on 3/21/2016.
 */
public class ConnectorMock extends Connector {

    public boolean doRealConnection() {
        System.out.println("Real Connection Override");
        return false;
    }
}
