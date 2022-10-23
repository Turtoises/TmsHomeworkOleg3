package by.tms.lesson31log.task2;

import by.tms.lesson31log.task2.pogo.Order;
import by.tms.lesson31log.task2.utils.SaveOrderAndLog;

import java.util.*;

public class MainTask2 {

    public static void main(String[] args) {

        //SaveOrderAndLog.saveOrder(111,18,2);

        Order newOrder=new Order(1890,123,2);

        Map<Long, List<Order>> actual=new HashMap<>();

        actual.put(1890L,new ArrayList<Order>(Arrays.asList(newOrder)));
        SaveOrderAndLog.saveOrder(1890,123,2);
        Map<Long, List<Order>> exactle=SaveOrderAndLog.getOrderMap();
        System.out.println(Objects.equals(actual,exactle));


    }
}
