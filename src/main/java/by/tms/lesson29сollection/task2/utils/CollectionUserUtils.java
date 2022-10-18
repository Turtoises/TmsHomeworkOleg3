package by.tms.lesson29сollection.task2.utils;

import by.tms.lesson29сollection.task2.pojo.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CollectionUserUtils {

    private CollectionUserUtils() {
    }

    private static List<String> getListWithNames(Path filePath) {
        List<String> listName = new ArrayList<>();

        try (Stream<String> names = Files.lines(filePath)) {
            listName = names.map(str -> str.split(" "))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listName;
    }

    private static List<User> createListRandomUsers(Path filePath) {
        List<String> listName = getListWithNames(filePath);
        List<User> userList = new ArrayList<>();
        Random random = new Random();

        userList = Stream.generate(() -> new User(listName.get(random.nextInt(listName.size())), random.nextInt(Constants.MAX_YEAR_USER)+1))
                .limit(Constants.AMOUNT_USER_IN_LIST)
                .collect(Collectors.toCollection(ArrayList::new));

        return userList;
    }

    public static void sortedAndPrintResult(Path filePath, int amountUser) {
        if (filePath == null || !filePath.toFile().exists()) {
            System.out.println("Not Such File");
        }

        new HashSet<User>(createListRandomUsers(filePath)).stream()
                .sorted(Comparator.comparingInt(User::getAge).reversed())
                .limit(amountUser).forEach(System.out::println);
    }
}
