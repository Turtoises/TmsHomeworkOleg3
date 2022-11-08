package by.tms.lesson36Pattern2.task3observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public abstract class AbstractSubscriber implements Subscriber {

    private String login;
    private String email;

    @Override
    public void update() {
        log.info("Dear {} the information was sent to {} ", login, email);
    }
}
