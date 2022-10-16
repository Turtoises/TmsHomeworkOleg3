package by.tms.lesson29сollection.task1.utils;

import by.tms.lesson29сollection.task1.pojo.AuthorDocuments;
import by.tms.lesson29сollection.task1.pojo.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DocumentsUtil {

    private DocumentsUtil() {
    }

    public static List<Document> getListDocuments(){
        List<Document> documentList=new ArrayList<>(Arrays.asList(
                new Document(1,12345, LocalDate.of(2020,2,20),new AuthorDocuments("Ivan","Ivanov",12)),
                new Document(2,17565, LocalDate.of(2020,2,20),new AuthorDocuments("Fedr","Petrov",22)),
                new Document(3, 187645, LocalDate.of(2020,2,20),new AuthorDocuments("Mikl","Young",45))
        ));
        return documentList;
    }


}
