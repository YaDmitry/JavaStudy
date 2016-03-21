package lec14_mockito.work;

import lec14_junit.work.Connector;
import lec14_junit.work.ConnectorMock;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;


/**
 * Created by dmya on 3/21/2016.
 */
public class TestCase {

    @Test
    public void testMock() {
        List<String> mockedList = mock(List.class);
        mockedList.add("add1");
        mockedList.add("add2");
        mockedList.clear();

        verify(mockedList).add("add1");
        verify(mockedList).clear();


    }

    @Test
    public void testWhen() {
        List<String> mockedList = mock(List.class);
        when(mockedList.add("add1")).thenThrow(new RuntimeException());

//        mockedList.add("add1");
        mockedList.clear();
//        verify(mockedList).add("add1");
        verify(mockedList).clear();
    }

    @Test
    public void testTimes() {
        List<String> mockedList = mock(List.class);

        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");
        mockedList.add("thierd");

        verify(mockedList, times(1)).add("once");
        verify(mockedList, never()).clear();
    }

    @Test
    public void testConnector() {

        Connector connectorMock = mock(Connector.class);

        doReturn(new ConnectorMock()).when(connectorMock.doRealConnection());
        verify(connectorMock).doRealConnection();
    }
}
