package by.tms.tmsmyproject.interceptors;

import by.tms.tmsmyproject.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LogInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();

        if (url.equals(Constants.COMMAND_CREATE_MAPPING)) {
            String login = request.getParameter("login");
            String email = request.getParameter("email");
            log.info("Request to create a user: login={}, email={}", login, email);
        }
        if (url.equals(Constants.COMMAND_GET_ALL_USERS_MAPPING)) {
            log.info("Request to show all users");
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println(response.getStatus());

    }
}
