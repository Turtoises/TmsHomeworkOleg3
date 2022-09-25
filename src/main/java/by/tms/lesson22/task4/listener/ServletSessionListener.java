package by.tms.lesson22.task4.listener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebListener
public class ServletSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session start time:" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session end time:" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
