package by.tms.lesson29сollection.task1.utils;

import by.tms.lesson29сollection.task1.pojo.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ReadFromFileUtil {

    private ReadFromFileUtil() {
    }

    private static Set<String> readFileAndGetSetContractNumbers(Path filePath) {

        Set<String> contractNumbers = new HashSet<>();

        try (Stream<String> fromFile = Files.lines(filePath)) {
            contractNumbers = fromFile.map(str -> str.split(" "))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toCollection(HashSet::new));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return contractNumbers;
    }

    private static Map<Long, Document> getMapDocuments(Path filePath) {
        List<Document> documentList = DocumentsUtil.getListDocuments();
        Map<Long, Document> documentMap = new HashMap<>();
        Set<String> contractNumbers = readFileAndGetSetContractNumbers(filePath);
        if (contractNumbers.isEmpty() || documentList.isEmpty()) {
            return documentMap;
        }
        documentMap = documentList.stream()
                .filter(document -> contractNumbers.contains(document.getNumberContract().toString()))
                .collect(Collectors.toMap(Document::getNumberContract, Function.identity()));

        return documentMap;
    }

    public static Map<Long, Document> getPrintingesult(Path filePath) {

        if (filePath == null || !filePath.toFile().exists()) {
            System.out.println("Not Such File");
            return new HashMap<>();
        }

        Map<Long, Document> documentMap = getMapDocuments(filePath);
        if (documentMap.isEmpty()) {
            System.out.println("No result");
            return new HashMap<>();
        }

        documentMap.entrySet().stream()
                .forEach(obj -> System.out.println(obj.getKey() + "-" + obj.getValue()));

        return documentMap;
    }
}
