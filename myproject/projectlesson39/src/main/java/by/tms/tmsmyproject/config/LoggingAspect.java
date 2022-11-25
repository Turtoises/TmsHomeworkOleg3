package by.tms.tmsmyproject.config;

import by.tms.tmsmyproject.entities.Author;
import by.tms.tmsmyproject.entities.ResponseMessage;
import by.tms.tmsmyproject.entities.User;
import by.tms.tmsmyproject.entities.dto.author.AuthorCreateDto;
import by.tms.tmsmyproject.entities.dto.user.UserCreateDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(by.tms.tmsmyproject.entities.ResponseMessage by.tms.tmsmyproject.services.UserServiceImpl.*(..))")
    public void userServices() {
    }

    @Pointcut("execution(by.tms.tmsmyproject.entities.ResponseMessage by.tms.tmsmyproject.services.AuthorServiceImpl.*(..))")
    public void authorServices() {
    }

    @Pointcut("execution(by.tms.tmsmyproject.entities.ResponseMessage by.tms.tmsmyproject.services.*ServiceImpl.create(..))")
    public void servicesCreat() {
    }

    @AfterReturning(value = "userServices() & !servicesCreat()", returning = "response")
    public void logUserService(JoinPoint joinPoint, ResponseMessage response) {
        Object[] args = joinPoint.getArgs();
        String nameMethod = joinPoint.getSignature().getName();
        log.info("UserServer method {} got arguments: {}", nameMethod, args);
        if (!response.getValid()) {
            log.warn("There are problems: {}", response.printMessage());
        } else {
            log.info("Result is successful");
        }
    }

    @AfterReturning(value = "authorServices() & !servicesCreat()", returning = "response")
    public void logAuthorService(JoinPoint joinPoint, ResponseMessage response) {
        Object[] args = joinPoint.getArgs();
        String nameMethod = joinPoint.getSignature().getName();
        log.info("AuthorServer method {} got arguments: {}", nameMethod, args);
        if (!response.getValid()) {
            log.warn("There are problems: {}", response.printMessage());
        } else {
            log.info("Result is successful");
        }
    }

    @AfterReturning(value = "servicesCreat()", returning = "response")
    public void logCreatEntity(JoinPoint joinPoint, ResponseMessage response) {
        if (response.getValid()) {
            Object entity = response.getObject();
            if (entity instanceof User) {
                log.info("Create {}", (UserCreateDto) response.getObject());
            } else if (entity instanceof Author) {
                log.info("Create {}", (AuthorCreateDto) response.getObject());
            }
        }
    }
}
