package by.tms.lesson31log.task2.utils;

import by.tms.lesson31log.task2.pogo.Item;

import java.util.HashMap;
import java.util.Map;

public final class MapItemUtil {

    private static Map<Long, Item> itemMap = getItemMapMap();

    private MapItemUtil() {
    }

    private static Map<Long, Item> getItemMapMap() {
        Map<Long, Item> itemMap = new HashMap<>();
        itemMap.put(123L, new Item("bad", 12345, 12));
        itemMap.put(18L, new Item("soup", 18, 10));
        itemMap.put(156L, new Item("banana", 156, 5));

        return itemMap;
    }

    public static boolean isItem(long itemID) {
        return itemMap.containsKey(itemID);
    }

    public static Item getItem(long itemID) {
        return itemMap.get(itemID);
    }

    public static boolean isListItemEmpty() {
        return (itemMap.isEmpty() || itemMap == null);
    }

    public static void setItemMap(Map<Long, Item> itemMap) {
        MapItemUtil.itemMap = itemMap;
    }
}
