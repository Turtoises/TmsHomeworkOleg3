package by.tms.lesson31log.task2.utils;

import by.tms.lesson31log.task2.pogo.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public final class SaveOrderAndLog {

    private static Map<Long, List<Order>> orderMap = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(SaveOrderAndLog.class);

    private SaveOrderAndLog() {
    }

    public static boolean saveOrder(long userID, long itemID, int amountItem) {

        if (MapUserUtil.isListUserEmpty()) {
            logger.debug(Costant.MESSAGE_USERS_EMPTY);
            return false;
        }

        if (MapItemUtil.isListItemEmpty()) {
            logger.debug(Costant.MESSAGE_ITEMS_EMPTY);
            return false;
        }

        if (!MapUserUtil.isUser(userID)) {
            logger.info(Costant.MESSAGE_USER_NOT_FIND);
            logger.info(Costant.MESSAGE_NOT_ADD);
            return false;
        }

        if (!MapItemUtil.isItem(itemID)) {
            logger.info(Costant.MESSAGE_ITEM_NOT_FIND);
            logger.info(Costant.MESSAGE_NOT_ADD);
            return false;
        }

        if (amountItem == 0) {
            logger.info(Costant.MESSAGE_NOT_AMOUNT_ITEM);
            logger.info(Costant.MESSAGE_NOT_ADD);
            return false;
        }

        if (amountItem < 0) {
            logger.info(Costant.MESSAGE_AMOUNT_ITEM_LESS_ZERO);
            logger.info(Costant.MESSAGE_NOT_ADD);
            return false;
        }

        Order newOrder = new Order(userID, itemID, amountItem);
        if (orderMap.containsKey(userID)) {
            List<Order> list = orderMap.get(userID);
            list.add(newOrder);
            orderMap.put(userID, list);
        } else {
            orderMap.put(userID, new ArrayList<>(Arrays.asList(newOrder)));
        }
        logger.info(Costant.MESSAGE_ADD_SUCCESSFUL);
        System.out.println(newOrder);
        return true;
    }

    public static Map<Long, List<Order>> getOrderMap() {
        return orderMap;
    }
}
