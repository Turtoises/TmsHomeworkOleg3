package by.tms.lesson29сollection.task1.pojo;

import java.time.LocalDate;
import java.util.Objects;

public class Document {

    private Long numberContract;
    private long numberDocument;
    private LocalDate date;
    private AuthorDocuments authorDocuments;

    public Document(long numberDocument, long numberContract, LocalDate date, AuthorDocuments authorDocuments) {
        this.numberContract = numberContract;
        this.numberDocument = numberDocument;
        this.date = date;
        this.authorDocuments = authorDocuments;
    }

    public Long getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(Long numberContract) {
        this.numberContract = numberContract;
    }

    public long getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(long numberDocument) {
        this.numberDocument = numberDocument;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AuthorDocuments getAuthorDocuments() {
        return authorDocuments;
    }

    public void setAuthorDocuments(AuthorDocuments authorDocuments) {
        this.authorDocuments = authorDocuments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return numberDocument == document.numberDocument && Objects.equals(numberContract, document.numberContract) && Objects.equals(date, document.date) && Objects.equals(authorDocuments, document.authorDocuments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberContract, numberDocument, date, authorDocuments);
    }

    @Override
    public String toString() {
        return "Document{" +
                "numberDocument=" + numberDocument +
                " numberContract=" + numberContract +
                ", date=" + date +
                ", authorDocuments=" + authorDocuments +
                '}';
    }
}
