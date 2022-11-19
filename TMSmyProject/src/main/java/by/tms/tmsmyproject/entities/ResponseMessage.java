package by.tms.tmsmyproject.entities;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
public class ResponseMessage {

    private Boolean isValid;
    private List<String> message = new ArrayList<>();
    private Object object;
    private User user;
    private Author author;

    public ResponseMessage(Boolean isValid) {
        this.isValid = isValid;
    }

    public ResponseMessage(Boolean isValid, String msg) {
        this.isValid = isValid;
        this.message.add(msg);
    }

    public ResponseMessage(Boolean isValid, Object object) {
        this.isValid = isValid;
        this.object = object;
        initField(object);
    }

    public ResponseMessage(Boolean isValid, List<String> message) {
        this.isValid = isValid;
        this.message = message;
    }

    public ResponseMessage(Boolean isValid, List<String> message, Object object) {
        this.isValid = isValid;
        this.message = message;
        this.object = object;
        initField(object);
    }

    public ResponseMessage setValid(Boolean valid) {
        isValid = valid;
        return this;
    }

    public Boolean getValid() {
        return isValid;
    }

    public ResponseMessage addMessage(String msg) {
        message.add(msg);
        return this;
    }

    public List<String> getMessage() {
        return message;
    }

    public ResponseMessage setObject(Object object) {
        this.object = object;
        initField(object);
        return this;
    }

    public User getUser() {
        return user;
    }

    public Author getAuthor() {
        return author;
    }

    private void initField(Object object) {
        if (object instanceof User) {
            this.user = (User) object;
        } else if (object instanceof Author) {
            this.author = (Author) object;
        }
    }
}
