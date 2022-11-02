package by.tms.lesson31log.task2;

import by.tms.lesson31log.task2.pogo.Order;
import by.tms.lesson31log.task2.utils.SaveOrderAndLog;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSaveOrderAndLog {

    @ParameterizedTest
    @CsvSource(value = {
            "1,1,2,false",
            "1890,123,2,true",
            "1890,1,2,false",
            "1890,123,0,false",
            "1890,123,-1,false"

    })
    public void testsaveOrder(long userID, long itemID, int amountItem, boolean result) {

        assertEquals(SaveOrderAndLog.saveOrder(userID, itemID, amountItem), result);

    }

    @ParameterizedTest
    @CsvSource(value = {
            "1890,123,2",

    })
    public void testsaveOrder2(long userID, long itemID, int amountItem) {

        Order newOrder=new Order(userID,itemID,amountItem);

        Map<Long, List<Order>> actual=new HashMap<>();

        actual.put(userID,new ArrayList<Order>(Arrays.asList(newOrder)));
        SaveOrderAndLog.saveOrder(userID, itemID, amountItem);
        Map<Long, List<Order>> exactle=SaveOrderAndLog.getOrderMap();

        assertTrue(Objects.equals(actual,exactle));

    }

}
